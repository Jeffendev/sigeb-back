package com.jeffry.sigep.estudiante.mapper;

import com.jeffry.sigep.estudiante.dto.EstudianteRequestDTO;
import com.jeffry.sigep.estudiante.dto.EstudianteResponseDTO;
import com.jeffry.sigep.estudiante.entity.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    public Estudiante toEntity(EstudianteRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        return Estudiante.builder()
                .codigo(dto.getCodigo())
                .documento(dto.getDocumento())
                .nombres(dto.getNombres())
                .apellidos(dto.getApellidos())
                .fechaNacimiento(dto.getFechaNacimiento())
                .sexo(dto.getSexo())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .acudiente(dto.getAcudiente())
                .telefonoAcudiente(dto.getTelefonoAcudiente())
                .build();
    }

    public EstudianteResponseDTO toResponse(Estudiante estudiante) {

        if (estudiante == null) {
            return null;
        }

        return EstudianteResponseDTO.builder()
                .id(estudiante.getId())
                .codigo(estudiante.getCodigo())
                .documento(estudiante.getDocumento())
                .nombres(estudiante.getNombres())
                .apellidos(estudiante.getApellidos())
                .fechaNacimiento(estudiante.getFechaNacimiento())
                .sexo(estudiante.getSexo())
                .correo(estudiante.getCorreo())
                .telefono(estudiante.getTelefono())
                .direccion(estudiante.getDireccion())
                .acudiente(estudiante.getAcudiente())
                .telefonoAcudiente(estudiante.getTelefonoAcudiente())
                .activo(estudiante.getActivo())
                .build();
    }
}