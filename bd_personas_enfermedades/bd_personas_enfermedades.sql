use bd_personas_enfermedades;

create table personas(
id int primary key auto_increment,
nombre varchar(40),
apellidos varchar (40),
edad numeric(2)
);

create table enfermedades(
id int primary key auto_increment,
nombre varchar(40),
tipo varchar (40),
duracio_dias numeric(2,2),
persona_id INT NOT NULL,
CONSTRAINT fk_enfermedad_persona
	FOREIGN KEY(persona_id)
    REFERENCES personas(id)
);

SET SQL_SAFE_UPDATES = 0;