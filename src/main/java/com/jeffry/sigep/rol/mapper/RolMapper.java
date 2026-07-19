package com.jeffry.sigep.rol.mapper;

import com.jeffry.sigep.rol.dto.RolRequest;
import com.jeffry.sigep.rol.dto.RolResponse;
import com.jeffry.sigep.rol.entity.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RolMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Rol toEntity(RolRequest request);

    RolResponse toResponse(Rol rol);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    void updateEntity(RolRequest request, @MappingTarget Rol rol);
}