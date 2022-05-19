insert into estudiante(nombre_estudiante, fecha_nacimiento, nombre_acudiente)
values('Estudienta Test 1', now() ,'Acudiente test 1');

insert into matricula_estudiante(id_estudiante, id_docente_sala, jornada, fecha_ingreso)
values(1, 1 ,'Completa', now());

insert into pension(id_estudiante, horas_multa, mes_pagado, valor_total)
values(1, 0, now(), 350000);

--insert into cliente(id, nombre, tipo_cliente) values(2,'Cliente 2','COMUN');
--insert into producto(id, nombre, aplica_iva, valor) values(1,'Producto 1',1, 25000);
--insert into producto(id, nombre, aplica_iva, valor) values(2,'Producto 2',0, 10000);
--
--insert into factura(id_cliente, valor_total, estado ) values(1, 25000, 'ACTIVA');
--insert into factura(id_cliente, valor_total, estado ) values(2, 3000, 'ANULADA');
--insert into producto_facturar( id_factura, id_producto, cantidad ) values(1, 1, 2);