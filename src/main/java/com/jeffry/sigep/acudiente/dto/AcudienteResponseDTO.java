package com.jeffry.sigep.acudiente.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcudienteResponseDTO {

    private Long id;

    private String documento;

    private String nombres;

    private String apellidos;

    private String correo;

    private String telefono;

    private String direccion;

    private String parentesco;

    private Boolean activo;
}
