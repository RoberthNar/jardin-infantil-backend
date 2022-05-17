create table estudiante (
 id int primary key not null auto_increment,
 nombre_estudiante varchar(50) not null,
 fecha_nacimiento datetime not null,
 nombre_acudiente varchar(50) not null
);

create table docente (
 id int primary key not null auto_increment,
 nombre_docente varchar(50) not null
);

create table sala (
 id int primary key not null auto_increment,
 nombre_sala varchar(50) not null,
 tipo_sala varchar(50) not null
);

create table docente_sala (
 id int primary key not null auto_increment,
 id_sala int not null,
    foreign key (id_sala) references sala(id),
 id_docente int not null,
    foreign key (id_docente) references docente(id)
);

create table matricula_estudiante (
 id int primary key not null auto_increment,
 id_estudiante int not null,
    foreign key (id_estudiante) references estudiante(id),
 id_docente_sala int not null,
    foreign key (id_docente_sala) references docente_sala(id),
 jornada varchar(50) not null,
 fecha_ingreso datetime not null
);

create table pension (
 id int primary key not null auto_increment,
 id_estudiante int not null,
    foreign key (id_estudiante) references estudiante(id),
 horas_multa int,
 mes_a_pagar datetime not null,
 valor_pagar decimal not null
);

create table costos (
 id int primary key not null auto_increment,
 valor_pension_maniana decimal not null,
 valor_pension_completa decimal not null,
 valor_multa decimal not null
);