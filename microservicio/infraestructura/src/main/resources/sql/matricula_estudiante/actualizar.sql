update matricula_estudiante
set id_estudiante = :idEstudiante,
    id_docente_sala = :idDocenteSala,
	jornada = :jornada,
	fecha_ingreso = :fechaIngreso

where id = :id