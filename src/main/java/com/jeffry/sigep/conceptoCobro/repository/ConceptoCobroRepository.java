package com.jeffry.sigep.conceptoCobro.repository;

import com.jeffry.sigep.conceptocobro.entity.ConceptoCobro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConceptoCobroRepository extends JpaRepository<ConceptoCobro, Long> {

    Optional<ConceptoCobro> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    List<ConceptoCobro> findByActivoTrue();

    Optional<ConceptoCobro> findByIdAndActivoTrue(Long id);
}