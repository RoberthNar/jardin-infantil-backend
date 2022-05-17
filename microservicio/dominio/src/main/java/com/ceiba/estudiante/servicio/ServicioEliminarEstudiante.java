package com.ceiba.estudiante.servicio;

import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;

public class ServicioEliminarEstudiante {

    private final RepositorioEstudiante repositorioEstudiante;

    public ServicioEliminarEstudiante(RepositorioEstudiante repositorioEstudiante) {
        this.repositorioEstudiante = repositorioEstudiante;
    }

    public void ejecutar(Long id) {
        this.repositorioEstudiante.eliminar(id);
    }

}
