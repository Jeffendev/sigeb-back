package com.jeffry.sigep.acudiente.controller;

import com.jeffry.sigep.acudiente.dto.AcudienteRequestDTO;
import com.jeffry.sigep.acudiente.dto.AcudienteResponseDTO;
import com.jeffry.sigep.acudiente.service.AcudienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acudientes")
@RequiredArgsConstructor
public class AcudienteController {

    private final AcudienteService acudienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcudienteResponseDTO crear(@RequestBody AcudienteRequestDTO request) {
        return acudienteService.crear(request);
    }

    @GetMapping
    public List<AcudienteResponseDTO> listar() {
        return acudienteService.listar();
    }

    @GetMapping("/{id}")
    public AcudienteResponseDTO buscarPorId(@PathVariable Long id) {
        return acudienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AcudienteResponseDTO actualizar(
            @PathVariable Long id,
            @RequestBody AcudienteRequestDTO request) {

        return acudienteService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        acudienteService.eliminar(id);
    }
}