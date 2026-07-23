package com.jeffry.sigep.estudiante.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteRequestDTO {

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
}
