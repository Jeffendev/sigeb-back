package com.jeffry.sigep.conceptoCobro.service;

import com.jeffry.sigep.conceptocobro.dto.ConceptoCobroRequestDTO;
import com.jeffry.sigep.conceptocobro.dto.ConceptoCobroResponseDTO;

import java.util.List;

public interface ConceptoCobroService {

    ConceptoCobroResponseDTO crear(ConceptoCobroRequestDTO request);

    List<ConceptoCobroResponseDTO> listar();

    ConceptoCobroResponseDTO buscarPorId(Long id);

    ConceptoCobroResponseDTO actualizar(Long id, ConceptoCobroRequestDTO request);

    void eliminar(Long id);
}