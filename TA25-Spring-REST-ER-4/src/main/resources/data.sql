DROP TABLE IF EXISTS peliculas;
DROP table IF EXISTS salas;


CREATE TABLE peliculas (
  id int NOT NULL AUTO_INCREMENT,
  nombre nvarchar(100),
  calificacion_edad int,
  PRIMARY KEY (id)
);

CREATE TABLE salas (
  id int NOT NULL AUTO_INCREMENT,
  nombre nvarchar(100),
  pelicula int,
  PRIMARY KEY (id),
  CONSTRAINT salas_fk FOREIGN KEY (pelicula) REFERENCES peliculas (id)
);


insert into peliculas (nombre, calificacion_edad) values ('Los Vengadores', 7);
insert into peliculas (nombre, calificacion_edad) values ('Deadpool', 16);
insert into peliculas (nombre, calificacion_edad) values ('Spiderman', 7);

insert into salas (nombre, pelicula) values ('Sala 1', 1);
insert into salas (nombre, pelicula) values ('Sala 2', 2);
insert into salas (nombre, pelicula) values ('Sala 3', 3);
