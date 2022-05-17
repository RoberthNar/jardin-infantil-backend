package com.ceiba.estudiante.comando.manejador;

import com.ceiba.estudiante.servicio.ServicioEliminarEstudiante;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEstudiante implements ManejadorComando<Long> {

    private final ServicioEliminarEstudiante servicioEliminarEstudiante;

    public ManejadorEliminarEstudiante(ServicioEliminarEstudiante servicioEliminarEstudiante) {
        this.servicioEliminarEstudiante = servicioEliminarEstudiante;
    }

    public void ejecutar(Long idEstudiante) {
        this.servicioEliminarEstudiante.ejecutar(idEstudiante);
    }
}
