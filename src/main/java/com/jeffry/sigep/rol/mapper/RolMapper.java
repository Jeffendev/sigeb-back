package com.jeffry.sigep.rol.mapper;

import com.jeffry.sigep.rol.dto.RolRequest;
import com.jeffry.sigep.rol.dto.RolResponse;
import com.jeffry.sigep.rol.entity.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper encargado de convertir entre la entidad Rol
 * y sus DTO utilizando MapStruct.
 *
 * @author Jeffry Arrieta
 * @since 1.0
 */
@Mapper(componentModel = "spring")
public interface RolMapper {

    /**
     * Convierte un RolRequest en una entidad Rol.
     */
    Rol toEntity(RolRequest request);

    /**
     * Convierte una entidad Rol en RolResponse.
     */
    RolResponse toResponse(Rol rol);

    /**
     * Actualiza una entidad existente con los datos del request.
     * No modifica el id.
     */
    @Mapping(target = "id", ignore = true)
    void updateEntity(RolRequest request, @MappingTarget Rol rol);

}