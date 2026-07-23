package com.jeffry.sigep.estudiante.service.impl;

import com.jeffry.sigep.common.exception.BadRequestException;
import com.jeffry.sigep.common.exception.ResourceNotFoundException;
import com.jeffry.sigep.estudiante.dto.EstudianteRequestDTO;
import com.jeffry.sigep.estudiante.dto.EstudianteResponseDTO;
import com.jeffry.sigep.estudiante.entity.Estudiante;
import com.jeffry.sigep.estudiante.mapper.EstudianteMapper;
import com.jeffry.sigep.estudiante.repository.EstudianteRepository;
import com.jeffry.sigep.estudiante.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    @Override
    public EstudianteResponseDTO crear(EstudianteRequestDTO request) {

        // Verificar código
        if (estudianteRepository.existsByCodigo(request.getCodigo())) {
            throw new BadRequestException("El código ya está registrado");
        }

        // Verificar documento
        if (estudianteRepository.existsByDocumento(request.getDocumento())) {
            throw new BadRequestException("El documento ya está registrado");
        }

        // Convertir DTO a entidad
        Estudiante estudiante = estudianteMapper.toEntity(request);

        // Guardar
        estudiante = estudianteRepository.save(estudiante);

        // Retornar DTO
        return estudianteMapper.toResponse(estudiante);
    }

    @Override
    public List<EstudianteResponseDTO> listar() {

        return estudianteRepository.findByActivoTrue()
                .stream()
                .map(estudianteMapper::toResponse)
                .toList();
    }

    @Override
    public EstudianteResponseDTO buscarPorId(Long id) {

        Estudiante estudiante = estudianteRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Estudiante no encontrado con id: " + id));

        return estudianteMapper.toResponse(estudiante);
    }

    @Override
    public EstudianteResponseDTO actualizar(Long id, EstudianteRequestDTO request) {

        // Buscar estudiante activo
        Estudiante estudiante = estudianteRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Estudiante no encontrado con id: " + id));

        // Validar código
        if (!estudiante.getCodigo().equals(request.getCodigo())
                && estudianteRepository.existsByCodigo(request.getCodigo())) {

            throw new BadRequestException("El código ya está registrado");
        }

        // Validar documento
        if (!estudiante.getDocumento().equals(request.getDocumento())
                && estudianteRepository.existsByDocumento(request.getDocumento())) {

            throw new BadRequestException("El documento ya está registrado");
        }

        // Actualizar datos
        estudiante.setCodigo(request.getCodigo());
        estudiante.setDocumento(request.getDocumento());
        estudiante.setNombres(request.getNombres());
        estudiante.setApellidos(request.getApellidos());
        estudiante.setFechaNacimiento(request.getFechaNacimiento());
        estudiante.setSexo(request.getSexo());
        estudiante.setCorreo(request.getCorreo());
        estudiante.setTelefono(request.getTelefono());
        estudiante.setDireccion(request.getDireccion());
        estudiante.setAcudiente(request.getAcudiente());
        estudiante.setTelefonoAcudiente(request.getTelefonoAcudiente());

        // Guardar cambios
        estudiante = estudianteRepository.save(estudiante);

        // Retornar respuesta
        return estudianteMapper.toResponse(estudiante);
    }

    @Override
    public void eliminar(Long id) {

        Estudiante estudiante = estudianteRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Estudiante no encontrado con id: " + id));

        estudiante.setActivo(false);

        estudianteRepository.save(estudiante);
    }
}