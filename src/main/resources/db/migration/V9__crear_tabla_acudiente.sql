-- =====================================================
-- V9 - Crear tabla acudiente
-- Módulo: Acudientes
-- =====================================================

CREATE TABLE acudiente (

                           id BIGINT AUTO_INCREMENT PRIMARY KEY,

                           documento VARCHAR(30) NOT NULL UNIQUE,

                           nombres VARCHAR(100) NOT NULL,

                           apellidos VARCHAR(100) NOT NULL,

                           correo VARCHAR(150),

                           telefono VARCHAR(20),

                           direccion VARCHAR(255),

                           parentesco VARCHAR(50),

                           activo BOOLEAN NOT NULL DEFAULT TRUE,

                           fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                           fecha_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
                               ON UPDATE CURRENT_TIMESTAMP

);

CREATE INDEX idx_acudiente_documento
    ON acudiente(documento);

CREATE INDEX idx_acudiente_nombres
    ON acudiente(nombres, apellidos);