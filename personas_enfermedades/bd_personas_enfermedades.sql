use bd_personas_enfermedades;

create table personas(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40),
    apellidoUno VARCHAR(20),
    apellidoDos VARCHAR(20),
    edad INT
);

create table enfermedades(
id INT PRIMARY KEY AUTO_INCREMENT,
dias_curacion INT NOT NULL,
nombre VARCHAR(100) NOT NULL,
persona_id INT NOT NULL,
CONSTRAINT fk_enfermedad_persona
	FOREIGN KEY(persona_id)
    REFERENCES personas(id)
);

SET SQL_SAFE_UPDATES = 0;