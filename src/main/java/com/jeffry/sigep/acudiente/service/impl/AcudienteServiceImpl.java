package com.jeffry.sigep.acudiente.service.impl;

import com.jeffry.sigep.acudiente.dto.AcudienteRequestDTO;
import com.jeffry.sigep.acudiente.dto.AcudienteResponseDTO;
import com.jeffry.sigep.acudiente.entity.Acudiente;
import com.jeffry.sigep.acudiente.mapper.AcudienteMapper;
import com.jeffry.sigep.acudiente.repository.AcudienteRepository;
import com.jeffry.sigep.acudiente.service.AcudienteService;
import com.jeffry.sigep.common.exception.BadRequestException;
import com.jeffry.sigep.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcudienteServiceImpl implements AcudienteService {

    private final AcudienteRepository acudienteRepository;
    private final AcudienteMapper acudienteMapper;

    @Override
    public AcudienteResponseDTO crear(AcudienteRequestDTO request) {

        // Verificar documento
        if (acudienteRepository.existsByDocumento(request.getDocumento())) {
            throw new BadRequestException("El documento ya está registrado");
        }

        // Convertir DTO a entidad
        Acudiente acudiente = acudienteMapper.toEntity(request);

        // Guardar
        acudiente = acudienteRepository.save(acudiente);

        // Retornar respuesta
        return acudienteMapper.toResponse(acudiente);
    }

    @Override
    public List<AcudienteResponseDTO> listar() {

        return acudienteRepository.findByActivoTrue()
                .stream()
                .map(acudienteMapper::toResponse)
                .toList();
    }

    @Override
    public AcudienteResponseDTO buscarPorId(Long id) {

        Acudiente acudiente = acudienteRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Acudiente no encontrado con id: " + id));

        return acudienteMapper.toResponse(acudiente);
    }

    @Override
    public AcudienteResponseDTO actualizar(Long id, AcudienteRequestDTO request) {

        // Buscar acudiente activo
        Acudiente acudiente = acudienteRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Acudiente no encontrado con id: " + id));

        // Validar documento
        if (!acudiente.getDocumento().equals(request.getDocumento())
                && acudienteRepository.existsByDocumento(request.getDocumento())) {

            throw new BadRequestException("El documento ya está registrado");
        }

        // Actualizar datos
        acudiente.setDocumento(request.getDocumento());
        acudiente.setNombres(request.getNombres());
        acudiente.setApellidos(request.getApellidos());
        acudiente.setCorreo(request.getCorreo());
        acudiente.setTelefono(request.getTelefono());
        acudiente.setDireccion(request.getDireccion());
        acudiente.setParentesco(request.getParentesco());

        // Guardar cambios
        acudiente = acudienteRepository.save(acudiente);

        // Retornar respuesta
        return acudienteMapper.toResponse(acudiente);
    }

    @Override
    public void eliminar(Long id) {

        Acudiente acudiente = acudienteRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Acudiente no encontrado con id: " + id));

        acudiente.setActivo(false);

        acudienteRepository.save(acudiente);
    }
}