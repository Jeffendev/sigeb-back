-- =====================================================
-- V7 - Crear tabla estudiante
-- Módulo: Estudiantes
-- =====================================================

CREATE TABLE estudiante (

                            id BIGINT AUTO_INCREMENT PRIMARY KEY,

                            codigo VARCHAR(20) NOT NULL UNIQUE,

                            documento VARCHAR(30) NOT NULL UNIQUE,

                            nombres VARCHAR(100) NOT NULL,

                            apellidos VARCHAR(100) NOT NULL,

                            fecha_nacimiento DATE,

                            sexo ENUM('M','F','O'),

                            correo VARCHAR(150),

                            telefono VARCHAR(20),

                            direccion VARCHAR(255),

                            acudiente VARCHAR(150),

                            telefono_acudiente VARCHAR(20),

                            activo BOOLEAN NOT NULL DEFAULT TRUE,

                            fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                            fecha_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
                                ON UPDATE CURRENT_TIMESTAMP

);

CREATE INDEX idx_estudiante_codigo
    ON estudiante(codigo);

CREATE INDEX idx_estudiante_documento
    ON estudiante(documento);

CREATE INDEX idx_estudiante_nombres
    ON estudiante(nombres, apellidos);