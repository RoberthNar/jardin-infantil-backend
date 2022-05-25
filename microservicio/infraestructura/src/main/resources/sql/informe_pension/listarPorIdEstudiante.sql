SELECT e.nombre_estudiante, e.fecha_nacimiento, e.nombre_acudiente
, m.jornada, d.nombre_docente, s.nombre_sala
, p.horas_multa, p.mes_pagado, p.valor_total 
FROM 
estudiante as e
left join pension p on e.id = p.id_estudiante
left join matricula_estudiante as m on e.id = m.id_estudiante
left join docente_sala as ds on m.id_docente_sala = ds.id
left join docente as d on ds.id_docente = d.id
left join sala as s on ds.id_sala = s.id
where e.id = :idEstudiante;