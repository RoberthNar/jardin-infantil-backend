package com.ceiba.matricula_estudiante.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.matricula_estudiante.servicio.ServicioEliminarMatriculaEstudiante;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarMatriculaEstudiante implements ManejadorComando<Long> {

    private final ServicioEliminarMatriculaEstudiante servicioEliminarMatriculaEstudiante;

    public ManejadorEliminarMatriculaEstudiante(ServicioEliminarMatriculaEstudiante servicioEliminarMatriculaEstudiante) {
        this.servicioEliminarMatriculaEstudiante = servicioEliminarMatriculaEstudiante;
    }

    public void ejecutar(Long idEstudiante) {
        this.servicioEliminarMatriculaEstudiante.ejecutar(idEstudiante);
    }
}
