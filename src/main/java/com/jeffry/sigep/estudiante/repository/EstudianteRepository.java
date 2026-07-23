package com.jeffry.sigep.estudiante.repository;

import com.jeffry.sigep.estudiante.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Optional<Estudiante> findByCodigo(String codigo);

    Optional<Estudiante> findByDocumento(String documento);

    boolean existsByCodigo(String codigo);

    boolean existsByDocumento(String documento);

    List<Estudiante> findByActivoTrue();

    Optional<Estudiante> findByIdAndActivoTrue(Long id);
}