package com.ceiba.pension.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pension.servicio.ServicioEliminarPension;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPension implements ManejadorComando<Long> {

    private final ServicioEliminarPension servicioEliminarPension;

    public ManejadorEliminarPension(ServicioEliminarPension servicioEliminarPension) {
        this.servicioEliminarPension = servicioEliminarPension;
    }

    public void ejecutar(Long idEstudiante) {
        this.servicioEliminarPension.ejecutar(idEstudiante);
    }
}
