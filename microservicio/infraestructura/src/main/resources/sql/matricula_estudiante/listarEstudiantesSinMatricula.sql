select es.id, es.nombre_estudiante, me.id_estudiante
from estudiante as es
left join matricula_estudiante as me on es.id = me.id_estudiante
where me.id_estudiante is null