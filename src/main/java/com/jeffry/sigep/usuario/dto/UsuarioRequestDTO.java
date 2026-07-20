package com.jeffry.sigep.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(min = 8, max = 255)
    private String password;

    @NotBlank
    @Email
    @Size(max = 150)
    private String correo;

    @NotBlank
    @Size(max = 100)
    private String nombres;

    @NotBlank
    @Size(max = 100)
    private String apellidos;

    @Size(max = 20)
    private String telefono;

    @Size(max = 30)
    private String documento;

    private Long rolId;
}