DROP TABLE IF EXISTS departamentos;
DROP table IF EXISTS empleado;

CREATE TABLE departamentos (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(100),
  presupuesto int,
  PRIMARY KEY (id)
);

CREATE TABLE empleado (
  dni varchar(9) NOT NULL,
  nombre varchar(100),
  apellidos varchar(255),
  departamento int NOT NULL,
  PRIMARY KEY (dni),
  FOREIGN KEY (departamento) REFERENCES departamentos (id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into departamentos (nombre, presupuesto) values ('Departamento 1', 1111);
insert into departamentos (nombre, presupuesto) values ('Departamento 2', 2222);
insert into departamentos (nombre, presupuesto) values ('Departamento 3', 3333);

insert into empleado (dni, nombre, apellidos, departamento) values ('12345678A', 'Andrea', 'Dal Pezzo', 1);
insert into empleado (dni, nombre, apellidos, departamento) values ('87654321B', 'Jose', 'Marín', 2);
insert into empleado (dni, nombre, apellidos, departamento) values ('12348765C', 'Yolanda', 'Martínez', 3);