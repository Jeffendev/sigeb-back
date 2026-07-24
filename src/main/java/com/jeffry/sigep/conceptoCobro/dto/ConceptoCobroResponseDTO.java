package com.jeffry.sigep.conceptocobro.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ConceptoCobroResponseDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private BigDecimal valor;

    private Boolean obligatorio;

    private Boolean activo;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;
}