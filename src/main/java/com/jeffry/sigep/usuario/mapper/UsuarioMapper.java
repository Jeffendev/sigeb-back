package com.jeffry.sigep.usuario.mapper;

import com.jeffry.sigep.usuario.dto.UsuarioRequestDTO;
import com.jeffry.sigep.usuario.dto.UsuarioResponseDTO;
import com.jeffry.sigep.usuario.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UsuarioMapper {

    /**
     * Convierte UsuarioRequestDTO a Usuario.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "ultimoAcceso", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    @Mapping(target = "rol", ignore = true)
    Usuario toEntity(UsuarioRequestDTO dto);

    /**
     * Convierte Usuario a UsuarioResponseDTO.
     */
    @Mapping(target = "rol", source = "rol.nombre")
    UsuarioResponseDTO toResponse(Usuario usuario);

}