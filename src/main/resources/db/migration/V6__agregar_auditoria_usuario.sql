-- =====================================================
-- V6 - Agregar campos de auditoría
-- Módulo: Seguridad
-- =====================================================

ALTER TABLE usuario
    ADD COLUMN creado_por BIGINT NULL AFTER fecha_actualizacion,
ADD COLUMN actualizado_por BIGINT NULL AFTER creado_por;

ALTER TABLE usuario
    ADD CONSTRAINT fk_usuario_creado_por
        FOREIGN KEY (creado_por)
            REFERENCES usuario(id);

ALTER TABLE usuario
    ADD CONSTRAINT fk_usuario_actualizado_por
        FOREIGN KEY (actualizado_por)
            REFERENCES usuario(id);

CREATE INDEX idx_usuario_creado_por
    ON usuario(creado_por);

CREATE INDEX idx_usuario_actualizado_por
    ON usuario(actualizado_por);