CREATE TABLE rol (

                     id BIGINT AUTO_INCREMENT PRIMARY KEY,

                     nombre VARCHAR(50) NOT NULL UNIQUE,

                     descripcion VARCHAR(255),

                     activo BOOLEAN NOT NULL DEFAULT TRUE,

                     fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                     fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                         ON UPDATE CURRENT_TIMESTAMP

);

CREATE TABLE usuario (

                         id BIGINT AUTO_INCREMENT PRIMARY KEY,

                         username VARCHAR(50) NOT NULL UNIQUE,

                         password VARCHAR(255) NOT NULL,

                         correo VARCHAR(150) NOT NULL UNIQUE,

                         activo BOOLEAN NOT NULL DEFAULT TRUE,

                         ultimo_acceso TIMESTAMP NULL,

                         fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                         fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                             ON UPDATE CURRENT_TIMESTAMP,

                         rol_id BIGINT NOT NULL,

                         CONSTRAINT fk_usuario_rol
                             FOREIGN KEY (rol_id)
                                 REFERENCES rol(id)

);

CREATE INDEX idx_usuario_username
    ON usuario(username);

CREATE INDEX idx_usuario_correo
    ON usuario(correo);