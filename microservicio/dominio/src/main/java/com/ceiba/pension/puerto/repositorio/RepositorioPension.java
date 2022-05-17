package com.ceiba.pension.puerto.repositorio;

import com.ceiba.pension.modelo.entidad.Pension;

public interface RepositorioPension {
    Long crear(Pension pension);

    void actualizar(Pension pension);

    void eliminar(Long id);

    boolean existePorId(Long id);
}
