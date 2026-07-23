package com.jeffry.sigep.estudiante.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EstudianteResponseDTO {

    private Long id;

    private String codigo;

    private String documento;

    private String nombres;

    private String apellidos;

    private LocalDate fechaNacimiento;

    private String sexo;

    private String correo;

    private String telefono;

    private String direccion;

    private String acudiente;

    private String telefonoAcudiente;

    private Boolean activo;
}