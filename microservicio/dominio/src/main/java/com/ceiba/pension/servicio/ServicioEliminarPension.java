package com.ceiba.pension.servicio;

import com.ceiba.pension.puerto.repositorio.RepositorioPension;

public class ServicioEliminarPension {

    private final RepositorioPension repositorioPension;

    public ServicioEliminarPension(RepositorioPension repositorioPension) {
        this.repositorioPension = repositorioPension;
    }

    public void ejecutar(Long id) {
        this.repositorioPension.eliminar(id);
    }

}
