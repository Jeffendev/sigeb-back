package com.jeffry.sigep.acudiente.repository;

import com.jeffry.sigep.acudiente.entity.Acudiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcudienteRepository extends JpaRepository<Acudiente, Long> {

    Optional<Acudiente> findByDocumento(String documento);

    boolean existsByDocumento(String documento);

    List<Acudiente> findByActivoTrue();

    Optional<Acudiente> findByIdAndActivoTrue(Long id);
}