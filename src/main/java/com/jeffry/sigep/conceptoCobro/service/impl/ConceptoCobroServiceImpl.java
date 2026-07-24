package com.jeffry.sigep.conceptoCobro.service.impl;

import com.jeffry.sigep.common.exception.BadRequestException;
import com.jeffry.sigep.common.exception.ResourceNotFoundException;
import com.jeffry.sigep.conceptocobro.dto.ConceptoCobroRequestDTO;
import com.jeffry.sigep.conceptocobro.dto.ConceptoCobroResponseDTO;
import com.jeffry.sigep.conceptocobro.entity.ConceptoCobro;
import com.jeffry.sigep.conceptoCobro.mapper.ConceptoCobroMapper;
import com.jeffry.sigep.conceptoCobro.repository.ConceptoCobroRepository;
import com.jeffry.sigep.conceptoCobro.service.ConceptoCobroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConceptoCobroServiceImpl implements ConceptoCobroService {

    private final ConceptoCobroRepository conceptoCobroRepository;
    private final ConceptoCobroMapper conceptoCobroMapper;

    @Override
    public ConceptoCobroResponseDTO crear(ConceptoCobroRequestDTO request) {

        if (conceptoCobroRepository.existsByNombre(request.getNombre())) {
            throw new BadRequestException("Ya existe un concepto con ese nombre");
        }

        ConceptoCobro concepto = conceptoCobroMapper.toEntity(request);

        concepto = conceptoCobroRepository.save(concepto);

        return conceptoCobroMapper.toResponse(concepto);
    }

    @Override
    public List<ConceptoCobroResponseDTO> listar() {

        return conceptoCobroRepository.findByActivoTrue()
                .stream()
                .map(conceptoCobroMapper::toResponse)
                .toList();
    }

    @Override
    public ConceptoCobroResponseDTO buscarPorId(Long id) {

        ConceptoCobro concepto = conceptoCobroRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Concepto de cobro no encontrado con id: " + id));

        return conceptoCobroMapper.toResponse(concepto);
    }

    @Override
    public ConceptoCobroResponseDTO actualizar(Long id, ConceptoCobroRequestDTO request) {

        ConceptoCobro concepto = conceptoCobroRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Concepto de cobro no encontrado con id: " + id));

        if (!concepto.getNombre().equals(request.getNombre())
                && conceptoCobroRepository.existsByNombre(request.getNombre())) {

            throw new BadRequestException("Ya existe un concepto con ese nombre");
        }

        concepto.setNombre(request.getNombre());
        concepto.setDescripcion(request.getDescripcion());
        concepto.setValor(request.getValor());
        concepto.setObligatorio(request.getObligatorio());

        concepto = conceptoCobroRepository.save(concepto);

        return conceptoCobroMapper.toResponse(concepto);
    }

    @Override
    public void eliminar(Long id) {

        ConceptoCobro concepto = conceptoCobroRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Concepto de cobro no encontrado con id: " + id));

        concepto.setActivo(false);

        conceptoCobroRepository.save(concepto);
    }
}