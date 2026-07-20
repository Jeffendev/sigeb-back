package com.jeffry.sigep.usuario.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioResponseDTO {

    private Long id;

    private String username;

    private String correo;

    private String nombres;

    private String apellidos;

    private String telefono;

    private String documento;

    private Boolean activo;

    private LocalDateTime ultimoAcceso;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

    private String rol;
}