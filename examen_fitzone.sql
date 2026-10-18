create table socios(
	id_socios INT primary key,
	nombres varchar(50) not null,
	apellidos varchar(50) not null,
	edad int not null,
	fecha_registro varchar(10) not null,
	activo boolean not null
);

select * from socios;

-- insersión de valores
INSERT INTO socios (id_socios, nombres, apellidos, edad, fecha_registro, activo) VALUES
(1, 'Carlos Andrés', 'Mendoza Ortiz', 28, '2026-01-15', true),
(2, 'Valeria Sofía', 'Gómez Castro', 16, '2026-03-22', true),
(3, 'Jorge Luis', 'Benítez Peralta', 34, '2026-06-10', false),
(4, 'Ana María', 'Silva Restrepo', 15, '2026-08-05', true),
(5, 'Mateo Sebastián', 'Rojas Neira', 21, '2026-10-17', true);

-- consulta solo nombres, apellidos y edad de los activos
select nombres, apellidos, edad from socios where activo = true;

-- consulta de socios con una fecha después del 2026-02-01
select * from socios where fecha_registro > '2026-02-01';

-- ordenados de mayor a menor

select * from socios order by edad desc;

--añadir columna
alter table socios add column email varchar(100);

-- actualizar email
update socios set email = 'MendOrtiz@email.com'
where id_socios = 1;
