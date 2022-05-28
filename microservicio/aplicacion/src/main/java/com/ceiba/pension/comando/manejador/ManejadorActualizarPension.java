package com.ceiba.pension.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pension.comando.ComandoPension;
import com.ceiba.pension.comando.fabrica.FabricaPension;
import com.ceiba.pension.modelo.entidad.Pension;
import com.ceiba.pension.servicio.ServicioActualizarPension;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPension implements ManejadorComando<ComandoPension> {

    private final FabricaPension fabricaPension;
    private final ServicioActualizarPension servicioActualizarPension;

    public ManejadorActualizarPension(FabricaPension fabricaPension,
                                      ServicioActualizarPension servicioActualizarPension) {
        this.fabricaPension = fabricaPension;
        this.servicioActualizarPension = servicioActualizarPension;
    }

    @Override
    public void ejecutar(ComandoPension comando) {
        Pension pension = this.fabricaPension.crear(comando);
        servicioActualizarPension.ejecutar(pension);

    }
}
