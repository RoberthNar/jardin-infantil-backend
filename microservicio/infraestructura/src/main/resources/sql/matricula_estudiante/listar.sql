select me.id, me.id_estudiante, es.nombre_estudiante, me.id_docente_sala, sa.nombre_sala,
doc.nombre_docente, me.jornada, me.fecha_ingreso
from matricula_estudiante as me
inner join estudiante as es on me.id_estudiante = es.id
inner join docente_sala as ds on me.id_docente_sala = ds.id
inner join sala as sa on sa.id = ds.id_sala
inner join docente as doc on doc.id = ds.id_docente