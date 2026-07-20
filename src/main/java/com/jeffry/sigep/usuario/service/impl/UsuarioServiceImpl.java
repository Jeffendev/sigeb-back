package com.jeffry.sigep.usuario.service.impl;

import com.jeffry.sigep.rol.repository.RolRepository;
import com.jeffry.sigep.usuario.dto.UsuarioRequestDTO;
import com.jeffry.sigep.usuario.dto.UsuarioResponseDTO;
import com.jeffry.sigep.usuario.mapper.UsuarioMapper;
import com.jeffry.sigep.usuario.repository.UsuarioRepository;
import com.jeffry.sigep.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO request) {
        return null;
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