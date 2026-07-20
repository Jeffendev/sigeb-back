package com.jeffry.sigep.usuario.service.impl;

import com.jeffry.sigep.rol.repository.RolRepository;
import com.jeffry.sigep.usuario.dto.UsuarioRequestDTO;
import com.jeffry.sigep.usuario.dto.UsuarioResponseDTO;
import com.jeffry.sigep.usuario.mapper.UsuarioMapper;
import com.jeffry.sigep.usuario.repository.UsuarioRepository;
import com.jeffry.sigep.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.jeffry.sigep.rol.entity.Rol;
import com.jeffry.sigep.usuario.entity.Usuario;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO request) {

        // Verificar que el username no exista
        if (usuarioRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }

        // Verificar que el correo no exista
        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Buscar el rol
        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Convertir DTO a entidad
        Usuario usuario = usuarioMapper.toEntity(request);

        // Asignar el rol
        usuario.setRol(rol);

        // Guardar en la base de datos
        usuario = usuarioRepository.save(usuario);

        // Convertir la entidad a ResponseDTO
        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listar() {
        return List.of();
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO request) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}