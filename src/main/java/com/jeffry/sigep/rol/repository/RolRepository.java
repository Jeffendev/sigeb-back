package com.jeffry.sigep.rol.repository;

import com.jeffry.sigep.rol.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para la gestión de la entidad {@link Rol}.
 *
 * <p>
 * Extiende {@link JpaRepository}, por lo que hereda automáticamente
 * las operaciones CRUD y de paginación proporcionadas por Spring Data JPA.
 * </p>
 *
 * <p>Métodos heredados más utilizados:</p>
 * <ul>
 *     <li>save()</li>
 *     <li>findById()</li>
 *     <li>findAll()</li>
 *     <li>deleteById()</li>
 *     <li>existsById()</li>
 *     <li>count()</li>
 * </ul>
 *
 * Además, este repositorio define consultas personalizadas para la
 * administración de roles.
 *
 * @author Jeffry Arrieta
 * @since 1.0
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    /**
     * Busca un rol por su nombre.
     *
     * @param nombre Nombre del rol.
     * @return Un {@link Optional} que contiene el rol si existe.
     */
    Optional<Rol> findByNombre(String nombre);

    /**
     * Verifica si existe un rol con el nombre especificado.
     *
     * @param nombre Nombre del rol.
     * @return {@code true} si existe; {@code false} en caso contrario.
     */
    boolean existsByNombre(String nombre);

}