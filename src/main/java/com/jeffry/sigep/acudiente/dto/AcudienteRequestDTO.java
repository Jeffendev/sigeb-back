package com.jeffry.sigep.acudiente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AcudienteRequestDTO {

    @NotBlank
    @Size(max = 30)
    private String documento;

    @NotBlank
    @Size(max = 100)
    private String nombres;

    @NotBlank
    @Size(max = 100)
    private String apellidos;

    @Email
    @Size(max = 150)
    private String correo;

    @Size(max = 20)
    private String telefono;

    @Size(max = 255)
    private String direccion;

    @Size(max = 50)
    private String parentesco;
}
