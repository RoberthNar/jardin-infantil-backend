package com.ceiba.estudiante.comando.manejador;

import com.ceiba.estudiante.comando.ComandoEstudiante;
import com.ceiba.estudiante.comando.fabrica.FabricaEstudiante;
import com.ceiba.estudiante.servicio.ServicioActualizarEstudiante;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEstudiante implements ManejadorComando<ComandoEstudiante> {

    private final FabricaEstudiante fabricaEstudiante;
    private final ServicioActualizarEstudiante servicioActualizarEstudiante;

    public ManejadorActualizarEstudiante(FabricaEstudiante fabricaEstudiante, ServicioActualizarEstudiante servicioActualizarEstudiante) {
        this.fabricaEstudiante = fabricaEstudiante;
        this.servicioActualizarEstudiante = servicioActualizarEstudiante;
    }

    @Override
    public void ejecutar(ComandoEstudiante comando) {

    }
}
