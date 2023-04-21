DROP TABLE IF EXISTS almacenes;
DROP table IF EXISTS cajas;


CREATE TABLE almacenes (
  id int NOT NULL AUTO_INCREMENT,
  lugar varchar(100),
  capacidad int DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE cajas (
  num_ref int  NOT NULL AUTO_INCREMENT,
  contenido varchar(100),
  valor int,
  almacen int DEFAULT NULL,
  PRIMARY KEY (num_ref),
  FOREIGN KEY (almacen) REFERENCES almacenes (id) ON DELETE CASCADE ON UPDATE CASCADE
);


insert into almacenes (lugar, capacidad) values ('Reus', 10);
insert into almacenes (lugar, capacidad) values ('Tarragona', 20);
insert into almacenes (lugar, capacidad) values ('Barcelona', 30);


insert into cajas (contenido, valor, almacen) values ('Bolsos', 100, 1);
insert into cajas (contenido, valor, almacen) values ('Zapatos', 200, 2);
insert into cajas (contenido, valor, almacen) values ('Ropa', 300, 3);

