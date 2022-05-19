insert into estudiante(nombre_estudiante, fecha_nacimiento, nombre_acudiente)
values('Estudienta Test 1', now() ,'Acudiente test 1');
insert into estudiante(nombre_estudiante, fecha_nacimiento, nombre_acudiente)
values('Estudienta Test 2', now() ,'Acudiente test 2');

insert into matricula_estudiante(id_estudiante, id_docente_sala, jornada, fecha_ingreso)
values(1, 1 ,'Completa', now());

insert into pension(id_estudiante, horas_multa, mes_pagado, valor_total)
values(1, 0, now(), 350000);