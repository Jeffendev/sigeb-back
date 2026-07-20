package com.jeffry.sigep.usuario.repository;

import com.jeffry.sigep.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     */
    Optional<Usuario> findByUsername(String username);

    /**
     * Busca un usuario por su correo electrónico.
     */
    Optional<Usuario> findByCorreo(String correo);

    /**
     * Verifica si existe un usuario con ese username.
     */
    boolean existsByUsername(String username);

    /**
     * Verifica si existe un usuario con ese correo.
     */
    boolean existsByCorreo(String correo);

    /**
     * Verifica si existe un usuario con ese documento.
     */
    boolean existsByDocumento(String documento);

}