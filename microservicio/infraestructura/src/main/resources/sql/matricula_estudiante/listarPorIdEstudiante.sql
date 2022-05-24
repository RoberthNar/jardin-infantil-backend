select id, id_estudiante, id_docente_sala, jornada, fecha_ingreso
from matricula_estudiante
where id_estudiante = :idEstudiante