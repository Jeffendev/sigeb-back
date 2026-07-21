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

import com.jeffry.sigep.common.exception.BadRequestException;
import com.jeffry.sigep.common.exception.ResourceNotFoundException;

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
            throw new BadRequestException("El nombre de usuario ya existe");
        }

        // Verificar que el correo no exista
        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new BadRequestException("El correo ya está registrado");
        }

        // Verificar que el documento no exista
        if (request.getDocumento() != null &&
                usuarioRepository.existsByDocumento(request.getDocumento())) {

            throw new BadRequestException("El documento ya está registrado");
        }

        // Buscar el rol
        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rol no encontrado"));

        // Convertir DTO a entidad
        Usuario usuario = usuarioMapper.toEntity(request);

        // Asignar el rol
        usuario.setRol(rol);

        // Guardar en la base de datos
        usuario = usuarioRepository.save(usuario);

        // Convertir a ResponseDTO
        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listar() {

        return usuarioRepository.findByActivoTrue()
                .stream()
                .map(usuarioMapper::toResponse)
                .toList();

    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {

        Usuario usuario = usuarioRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario no encontrado con id: " + id));

        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO request) {

        // Buscar el usuario activo
        Usuario usuario = usuarioRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario no encontrado con id: " + id));

        // Validar username
        if (!usuario.getUsername().equals(request.getUsername())
                && usuarioRepository.existsByUsername(request.getUsername())) {

            throw new BadRequestException("El nombre de usuario ya existe");
        }

        // Validar correo
        if (!usuario.getCorreo().equals(request.getCorreo())
                && usuarioRepository.existsByCorreo(request.getCorreo())) {

            throw new BadRequestException("El correo ya está registrado");
        }

        // Validar documento
        if (request.getDocumento() != null
                && !request.getDocumento().equals(usuario.getDocumento())
                && usuarioRepository.existsByDocumento(request.getDocumento())) {

            throw new BadRequestException("El documento ya está registrado");
        }

        // Buscar el rol
        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rol no encontrado"));

        // Actualizar datos
        usuario.setUsername(request.getUsername());
        usuario.setPassword(request.getPassword());
        usuario.setCorreo(request.getCorreo());
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());
        usuario.setTelefono(request.getTelefono());
        usuario.setDocumento(request.getDocumento());
        usuario.setRol(rol);

        // Guardar cambios
        usuario = usuarioRepository.save(usuario);

        // Retornar respuesta
        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public void eliminar(Long id) {

        Usuario usuario = usuarioRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario no encontrado con id: " + id));

        usuario.setActivo(false);

        usuarioRepository.save(usuario);
    }
}