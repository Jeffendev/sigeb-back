CREATE TABLE concepto_cobro (

                                id BIGINT PRIMARY KEY AUTO_INCREMENT,

                                nombre VARCHAR(100) NOT NULL UNIQUE,

                                descripcion VARCHAR(255),

                                valor DECIMAL(12,2) NOT NULL,

                                obligatorio BOOLEAN NOT NULL DEFAULT FALSE,

                                activo BOOLEAN NOT NULL DEFAULT TRUE,

                                fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                                    ON UPDATE CURRENT_TIMESTAMP

);