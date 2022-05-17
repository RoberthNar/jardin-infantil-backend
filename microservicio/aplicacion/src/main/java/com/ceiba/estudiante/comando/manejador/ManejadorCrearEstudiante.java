package com.ceiba.estudiante.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.estudiante.comando.ComandoEstudiante;
import com.ceiba.estudiante.comando.fabrica.FabricaEstudiante;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.ServicioCrearEstudiante;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEstudiante implements ManejadorComandoRespuesta<ComandoEstudiante, ComandoRespuesta<Long>> {

    private final FabricaEstudiante fabricaEstudiante;
    private final ServicioCrearEstudiante servicioCrearEstudiante;

    public ManejadorCrearEstudiante(FabricaEstudiante fabricaEstudiante, ServicioCrearEstudiante servicioCrearEstudiante) {
        this.fabricaEstudiante = fabricaEstudiante;
        this.servicioCrearEstudiante = servicioCrearEstudiante;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEstudiante comandoEstudiante) {
        Estudiante estudiante = this.fabricaEstudiante.crear(comandoEstudiante);
        return new ComandoRespuesta<>(this.servicioCrearEstudiante.ejecutar(estudiante));
    }

}
