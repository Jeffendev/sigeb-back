CREATE TABLE grado (

                       id BIGINT AUTO_INCREMENT PRIMARY KEY,

                       nombre VARCHAR(20) NOT NULL,

                       nivel VARCHAR(20) NOT NULL,

                       activo BOOLEAN DEFAULT TRUE,

                       fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);


CREATE TABLE docente (

                         id BIGINT AUTO_INCREMENT PRIMARY KEY,

                         documento VARCHAR(20) NOT NULL UNIQUE,

                         nombres VARCHAR(100) NOT NULL,

                         apellidos VARCHAR(100) NOT NULL,

                         telefono VARCHAR(20),

                         correo VARCHAR(150),

                         especialidad VARCHAR(100),

                         usuario_id BIGINT UNIQUE,

                         CONSTRAINT fk_docente_usuario
                             FOREIGN KEY(usuario_id)
                                 REFERENCES usuario(id)

);

CREATE TABLE acudiente (

                           id BIGINT AUTO_INCREMENT PRIMARY KEY,

                           documento VARCHAR(20) NOT NULL UNIQUE,

                           nombres VARCHAR(100) NOT NULL,

                           apellidos VARCHAR(100) NOT NULL,

                           telefono VARCHAR(20),

                           correo VARCHAR(150),

                           direccion VARCHAR(200)

);

CREATE TABLE estudiante (

                            id BIGINT AUTO_INCREMENT PRIMARY KEY,

                            codigo VARCHAR(20) NOT NULL UNIQUE,

                            documento VARCHAR(20) NOT NULL UNIQUE,

                            nombres VARCHAR(100) NOT NULL,

                            apellidos VARCHAR(100) NOT NULL,

                            fecha_nacimiento DATE,

                            sexo VARCHAR(20),

                            direccion VARCHAR(200),

                            telefono VARCHAR(20),

                            correo VARCHAR(150),

                            estado VARCHAR(20),

                            acudiente_id BIGINT NOT NULL,

                            CONSTRAINT fk_estudiante_acudiente
                                FOREIGN KEY(acudiente_id)
                                    REFERENCES acudiente(id)

);

CREATE INDEX idx_estudiante_codigo
    ON estudiante(codigo);

CREATE INDEX idx_estudiante_documento
    ON estudiante(documento);
