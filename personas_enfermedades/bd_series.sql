USE bd_series;

CREATE TABLE series (
	id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    edad INT,
    plataforma VARCHAR(40),
    CONSTRAINT chk_edad CHECK (edad IN (0, 3, 7, 12, 16, 18))
    );

CREATE TABLE temporadas (
id INT PRIMARY KEY AUTO_INCREMENT,
num_temporada INT NOT NULL,
titulo VARCHAR(100) NOT NULL,
serie_id INT NOT NULL,
CONSTRAINT fk_temporada_serie
	FOREIGN KEY(serie_id)
    REFERENCES series(id)
);