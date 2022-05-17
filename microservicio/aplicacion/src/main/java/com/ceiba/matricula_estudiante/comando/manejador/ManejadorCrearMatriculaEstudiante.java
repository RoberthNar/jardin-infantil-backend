package com.ceiba.matricula_estudiante.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.matricula_estudiante.comando.ComandoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.comando.fabrica.FabricaMatriculaEstudiante;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.ServicioCrearMatriculaEstudiante;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearMatriculaEstudiante implements ManejadorComandoRespuesta<ComandoMatriculaEstudiante, ComandoRespuesta<Long>> {

    private final FabricaMatriculaEstudiante fabricaMatriculaEstudiante;
    private final ServicioCrearMatriculaEstudiante servicioCrearMatriculaEstudiante;

    public ManejadorCrearMatriculaEstudiante(FabricaMatriculaEstudiante fabricaMatriculaEstudiante,
                                             ServicioCrearMatriculaEstudiante servicioCrearMatriculaEstudiante) {
        this.fabricaMatriculaEstudiante = fabricaMatriculaEstudiante;
        this.servicioCrearMatriculaEstudiante = servicioCrearMatriculaEstudiante;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoMatriculaEstudiante comandoMatriculaEstudiante) {
        MatriculaEstudiante matriculaEstudiante = this.fabricaMatriculaEstudiante.crear(comandoMatriculaEstudiante);
        return new ComandoRespuesta<>(this.servicioCrearMatriculaEstudiante.ejecutar(matriculaEstudiante));
    }

}
