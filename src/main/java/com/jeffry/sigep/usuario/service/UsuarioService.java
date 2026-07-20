package com.jeffry.sigep.usuario.service;

import com.jeffry.sigep.usuario.dto.UsuarioRequestDTO;
import com.jeffry.sigep.usuario.dto.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    /**
     * Crear un nuevo usuario.
     */
    UsuarioResponseDTO crear(UsuarioRequestDTO request);

    /**
     * Obtener todos los usuarios.
     */
    List<UsuarioResponseDTO> listar();

    /**
     * Buscar un usuario por su ID.
     */
    UsuarioResponseDTO buscarPorId(Long id);

    /**
     * Actualizar un usuario.
     */
    UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO request);

    /**
     * Eliminar un usuario.
     */
    void eliminar(Long id);
}