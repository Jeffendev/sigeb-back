package com.jeffry.sigep.acudiente.service;

import com.jeffry.sigep.acudiente.dto.AcudienteRequestDTO;
import com.jeffry.sigep.acudiente.dto.AcudienteResponseDTO;

import java.util.List;

public interface AcudienteService {

    AcudienteResponseDTO crear(AcudienteRequestDTO request);

    List<AcudienteResponseDTO> listar();

    AcudienteResponseDTO buscarPorId(Long id);

    AcudienteResponseDTO actualizar(Long id, AcudienteRequestDTO request);

    void eliminar(Long id);
}