package com.ceiba.matricula_estudiante.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.matricula_estudiante.comando.ComandoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.comando.fabrica.FabricaMatriculaEstudiante;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.ServicioActualizarMatriculaEstudiante;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarMatriculaEstudiante implements ManejadorComando<ComandoMatriculaEstudiante> {

    private final FabricaMatriculaEstudiante fabricaMatriculaEstudiante;
    private final ServicioActualizarMatriculaEstudiante servicioActualizarMatriculaEstudiante;

    public ManejadorActualizarMatriculaEstudiante(FabricaMatriculaEstudiante fabricaMatriculaEstudiante, ServicioActualizarMatriculaEstudiante servicioActualizarMatriculaEstudiante) {
        this.fabricaMatriculaEstudiante = fabricaMatriculaEstudiante;
        this.servicioActualizarMatriculaEstudiante = servicioActualizarMatriculaEstudiante;
    }

    @Override
    public void ejecutar(ComandoMatriculaEstudiante comando) {
        MatriculaEstudiante matriculaEstudiante = this.fabricaMatriculaEstudiante.crear(comando);
        servicioActualizarMatriculaEstudiante.ejecutar(matriculaEstudiante);

    }
}
