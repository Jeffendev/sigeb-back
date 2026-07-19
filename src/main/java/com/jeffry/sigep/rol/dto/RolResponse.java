package com.jeffry.sigep.rol.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO utilizado para devolver la información de un rol al cliente.
 *
 * @author Jeffry Arrieta
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolResponse {

    private Long id;

    private String nombre;

    private String descripcion;

    private Boolean activo;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

}