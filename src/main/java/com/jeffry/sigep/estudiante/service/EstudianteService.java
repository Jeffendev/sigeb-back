package com.jeffry.sigep.estudiante.service;

import com.jeffry.sigep.estudiante.dto.EstudianteRequestDTO;
import com.jeffry.sigep.estudiante.dto.EstudianteResponseDTO;

import java.util.List;

public interface EstudianteService {

    EstudianteResponseDTO crear(EstudianteRequestDTO request);

    List<EstudianteResponseDTO> listar();

    EstudianteResponseDTO buscarPorId(Long id);

    EstudianteResponseDTO actualizar(Long id, EstudianteRequestDTO request);

    void eliminar(Long id);
}