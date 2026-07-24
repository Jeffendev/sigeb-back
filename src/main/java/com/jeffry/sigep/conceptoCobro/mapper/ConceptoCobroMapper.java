package com.jeffry.sigep.conceptoCobro.mapper;

import com.jeffry.sigep.conceptocobro.dto.ConceptoCobroRequestDTO;
import com.jeffry.sigep.conceptocobro.dto.ConceptoCobroResponseDTO;
import com.jeffry.sigep.conceptocobro.entity.ConceptoCobro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConceptoCobroMapper {

    ConceptoCobro toEntity(ConceptoCobroRequestDTO request);

    ConceptoCobroResponseDTO toResponse(ConceptoCobro conceptoCobro);
}