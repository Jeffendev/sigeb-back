package com.jeffry.sigep.conceptoCobro.controller;

import com.jeffry.sigep.conceptocobro.dto.ConceptoCobroRequestDTO;
import com.jeffry.sigep.conceptocobro.dto.ConceptoCobroResponseDTO;
import com.jeffry.sigep.conceptoCobro.service.ConceptoCobroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conceptos-cobro")
@RequiredArgsConstructor
public class ConceptoCobroController {

    private final ConceptoCobroService conceptoCobroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConceptoCobroResponseDTO crear(@RequestBody ConceptoCobroRequestDTO request) {
        return conceptoCobroService.crear(request);
    }

    @GetMapping
    public List<ConceptoCobroResponseDTO> listar() {
        return conceptoCobroService.listar();
    }

    @GetMapping("/{id}")
    public ConceptoCobroResponseDTO buscarPorId(@PathVariable Long id) {
        return conceptoCobroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ConceptoCobroResponseDTO actualizar(
            @PathVariable Long id,
            @RequestBody ConceptoCobroRequestDTO request) {

        return conceptoCobroService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        conceptoCobroService.eliminar(id);
    }
}