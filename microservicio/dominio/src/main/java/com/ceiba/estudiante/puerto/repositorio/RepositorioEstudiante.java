package com.ceiba.estudiante.puerto.repositorio;

import com.ceiba.estudiante.modelo.entidad.Estudiante;

public interface RepositorioEstudiante {
    Long crear(Estudiante estudiante);

    void actualizar(Estudiante estudiante);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existePorId(Long id);
}
