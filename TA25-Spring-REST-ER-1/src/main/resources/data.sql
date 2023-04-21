DROP TABLE IF EXISTS articulos;
DROP TABLE IF EXISTS fabricantes;

CREATE TABLE fabricantes (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE articulos (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio INT,
    codigo_fabricantes INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (codigo_fabricantes) REFERENCES fabricantes (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO fabricantes(nombre) VALUES ('Samsung');
INSERT INTO fabricantes(nombre) VALUES ('Apple');

INSERT INTO articulos(nombre, precio, codigo_fabricantes) VALUES ('Galaxy Z Flip 4', 1099, 1);
INSERT INTO articulos(nombre, precio, codigo_fabricantes) VALUES ('Iphone 14', 1120, 2);