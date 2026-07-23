package com.jeffry.sigep.acudiente.mapper;

import com.jeffry.sigep.acudiente.dto.AcudienteRequestDTO;
import com.jeffry.sigep.acudiente.dto.AcudienteResponseDTO;
import com.jeffry.sigep.acudiente.entity.Acudiente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcudienteMapper {

    Acudiente toEntity(AcudienteRequestDTO request);

    AcudienteResponseDTO toResponse(Acudiente acudiente);
}