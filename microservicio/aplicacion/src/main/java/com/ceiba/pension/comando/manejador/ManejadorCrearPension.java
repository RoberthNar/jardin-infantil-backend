package com.ceiba.pension.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pension.comando.ComandoPension;
import com.ceiba.pension.comando.fabrica.FabricaPension;
import com.ceiba.pension.modelo.entidad.Pension;
import com.ceiba.pension.servicio.ServicioCrearPension;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPension implements ManejadorComandoRespuesta<ComandoPension, ComandoRespuesta<Long>> {

    private final FabricaPension fabricaPension;
    private final ServicioCrearPension servicioCrearPension;

    public ManejadorCrearPension(FabricaPension fabricaPension, ServicioCrearPension servicioCrearPension) {
        this.fabricaPension = fabricaPension;
        this.servicioCrearPension = servicioCrearPension;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPension comandoPension) {
        Pension pension = this.fabricaPension.crear(comandoPension);
        return new ComandoRespuesta<>(this.servicioCrearPension.ejecutar(pension));
    }

}
