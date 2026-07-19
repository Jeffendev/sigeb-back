package com.jeffry.sigep.rol.service;

import com.jeffry.sigep.rol.dto.RolRequest;
import com.jeffry.sigep.rol.dto.RolResponse;

import java.util.List;

/**
 * Define las operaciones de negocio para la gestión de roles.
 *
 * @author Jeffry Arrieta
 * @since 1.0
 */
public interface RolService {

    /**
     * Obtiene todos los roles.
     *
     * @return Lista de roles.
     */
    List<RolResponse> listar();

    /**
     * Busca un rol por su id.
     *
     * @param id Identificador del rol.
     * @return Rol encontrado.
     */
    RolResponse buscarPorId(Long id);

    /**
     * Crea un nuevo rol.
     *
     * @param request Datos del rol.
     * @return Rol creado.
     */
    RolResponse crear(RolRequest request);

    /**
     * Actualiza un rol existente.
     *
     * @param id Identificador del rol.
     * @param request Datos actualizados.
     * @return Rol actualizado.
     */
    RolResponse actualizar(Long id, RolRequest request);

    /**
     * Elimina un rol.
     *
     * @param id Identificador del rol.
     */
    void eliminar(Long id);
}