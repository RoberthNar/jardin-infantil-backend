package com.ceiba.pension.puerto.dao;


import com.ceiba.pension.modelo.dto.DtoInformePension;

import java.util.List;

public interface DaoInformePension {

    DtoInformePension listarPorIdEstudiante(Long idEstudiante);
    List<DtoInformePension> listarInforme();

}
