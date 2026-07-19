package com.jeffry.sigep.rol.controller;

import com.jeffry.sigep.rol.dto.RolRequest;
import com.jeffry.sigep.rol.dto.RolResponse;
import com.jeffry.sigep.rol.service.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de roles.
 *
 * Expone los endpoints para realizar operaciones CRUD sobre la entidad Rol.
 *
 * @author Jeffry Arrieta
 * @since 1.0
 */
@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@Tag(name = "Roles", description = "API para la gestión de roles del sistema")
public class RolController {

    private final RolService rolService;

    /**
     * Obtiene todos los roles.
     *
     * @return Lista de roles.
     */
    @Operation(summary = "Listar todos los roles")
    @GetMapping
    public ResponseEntity<List<RolResponse>> listar() {
        return ResponseEntity.ok(rolService.listar());
    }

    /**
     * Obtiene un rol por su identificador.
     *
     * @param id Identificador del rol.
     * @return Rol encontrado.
     */
    @Operation(summary = "Buscar un rol por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<RolResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.buscarPorId(id));
    }

    /**
     * Crea un nuevo rol.
     *
     * @param request Información del rol.
     * @return Rol creado.
     */
    @Operation(summary = "Crear un nuevo rol")
    @PostMapping
    public ResponseEntity<RolResponse> crear(@Valid @RequestBody RolRequest request) {
        RolResponse response = rolService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Actualiza un rol existente.
     *
     * @param id Identificador del rol.
     * @param request Nueva información del rol.
     * @return Rol actualizado.
     */
    @Operation(summary = "Actualizar un rol")
    @PutMapping("/{id}")
    public ResponseEntity<RolResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody RolRequest request) {

        return ResponseEntity.ok(rolService.actualizar(id, request));
    }

    /**
     * Elimina un rol por su identificador.
     *
     * @param id Identificador del rol.
     */
    @Operation(summary = "Eliminar un rol")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        rolService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}