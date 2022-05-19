create table estudiante (
 id int primary key auto_increment,
 nombre_estudiante varchar(50) not null,
 fecha_nacimiento datetime not null,
 nombre_acudiente varchar(50) not null
);

create table docente (
 id int primary key auto_increment,
 nombre_docente varchar(50) not null
);

create table sala (
 id int primary key auto_increment,
 nombre_sala varchar(50) not null,
 tipo_sala varchar(50) not null
);

create table docente_sala (
 id int primary key auto_increment,
 id_sala int not null,
    foreign key (id_sala) references sala(id),
 id_docente int not null,
    foreign key (id_docente) references docente(id)
);

create table matricula_estudiante (
 id int primary key auto_increment,
 id_estudiante int not null,
    foreign key (id_estudiante) references estudiante(id),
 id_docente_sala int not null,
    foreign key (id_docente_sala) references docente_sala(id),
 jornada varchar(50) not null,
 fecha_ingreso datetime not null
);

create table pension (
 id int primary key auto_increment,
 id_estudiante int not null,
    foreign key (id_estudiante) references estudiante(id),
 horas_multa int,
 mes_pagado datetime not null,
 valor_total decimal not null
);

create table costos (
 id int primary key auto_increment,
 valor_pension_maniana decimal not null,
 valor_pension_completa decimal not null,
 valor_multa decimal not null
);

INSERT INTO docente(nombre_docente) VALUES ('docente caminadores 1');
INSERT INTO docente(nombre_docente) VALUES ('docente caminadores 2');
INSERT INTO docente(nombre_docente) VALUES ('docente Parbulos');
INSERT INTO docente(nombre_docente) VALUES ('docente Prejardin');
INSERT INTO docente(nombre_docente) VALUES ('docente Jardin');

INSERT INTO sala(nombre_sala, tipo_sala) VALUES ('Sala Cuna', 'Bebesitos');
INSERT INTO sala(nombre_sala, tipo_sala) VALUES ('Parbulos', 'Caminadores');
INSERT INTO sala(nombre_sala, tipo_sala) VALUES ('Prejardin', 'Exploradores');
INSERT INTO sala(nombre_sala, tipo_sala) VALUES ('Jardin', 'Conocedores');

INSERT INTO docente_sala(id_sala, id_docente) VALUES (1, 1);
INSERT INTO docente_sala(id_sala, id_docente) VALUES (1, 2);
INSERT INTO docente_sala(id_sala, id_docente) VALUES (2, 3);
INSERT INTO docente_sala(id_sala, id_docente) VALUES (3, 4);
INSERT INTO docente_sala(id_sala, id_docente) VALUES (4, 5);




