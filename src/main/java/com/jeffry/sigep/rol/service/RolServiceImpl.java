package com.jeffry.sigep.rol.service;

import com.jeffry.sigep.rol.dto.RolRequest;
import com.jeffry.sigep.rol.dto.RolResponse;
import com.jeffry.sigep.rol.entity.Rol;
import com.jeffry.sigep.rol.mapper.RolMapper;
import com.jeffry.sigep.rol.repository.RolRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public List<RolResponse> listar() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toResponse)
                .toList();
    }

    @Override
    public RolResponse buscarPorId(Long id) {

        Rol rol = rolRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Rol no encontrado con id: " + id));

        return rolMapper.toResponse(rol);
    }

    @Override
    public RolResponse crear(RolRequest request) {

        if (rolRepository.existsByNombre(request.getNombre())) {
            throw new IllegalArgumentException("Ya existe un rol con ese nombre.");
        }

        Rol rol = rolMapper.toEntity(request);

        Rol rolGuardado = rolRepository.save(rol);

        return rolMapper.toResponse(rolGuardado);
    }

    @Override
    public RolResponse actualizar(Long id, RolRequest request) {

        Rol rol = rolRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Rol no encontrado con id: " + id));

        rolMapper.updateEntity(request, rol);

        Rol rolActualizado = rolRepository.save(rol);

        return rolMapper.toResponse(rolActualizado);
    }

    @Override
    public void eliminar(Long id) {

        if (!rolRepository.existsById(id)) {
            throw new EntityNotFoundException("Rol no encontrado con id: " + id);
        }

        rolRepository.deleteById(id);
    }
}
