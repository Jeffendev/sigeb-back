-- =====================================================
-- V8 - Insertar roles iniciales
-- =====================================================

INSERT INTO rol (nombre, descripcion, activo, fecha_creacion, fecha_actualizacion)
VALUES
    ('ADMIN', 'Administrador del sistema', TRUE, NOW(), NOW()),
    ('DOCENTE', 'Docente de la institución', TRUE, NOW(), NOW()),
    ('ESTUDIANTE', 'Estudiante del sistema', TRUE, NOW(), NOW()),
    ('ACUDIENTE', 'Acudiente del estudiante', TRUE, NOW(), NOW());