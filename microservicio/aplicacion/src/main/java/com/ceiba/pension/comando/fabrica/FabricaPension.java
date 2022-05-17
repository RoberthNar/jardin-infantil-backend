package com.ceiba.pension.comando.fabrica;

import com.ceiba.estudiante.comando.ComandoEstudiante;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.pension.comando.ComandoPension;
import com.ceiba.pension.modelo.entidad.Pension;
import org.springframework.stereotype.Component;

@Component
public class FabricaPension {

    public Pension crear(ComandoPension comandoPension) {
        return new Pension(comandoPension.getId(),
                comandoPension.getIdEstudiante(),
                comandoPension.getHorasMulta(),
                comandoPension.getMesPagado(),
                comandoPension.getValorTotal());
    }
}
