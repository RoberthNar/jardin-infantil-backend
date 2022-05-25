package com.ceiba.pension.consulta;


import com.ceiba.pension.modelo.dto.DtoInformePension;
import com.ceiba.pension.puerto.dao.DaoInformePension;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarPensionEstudiantePorId {

    private final DaoInformePension daoInformePension;

    public ManejadorListarPensionEstudiantePorId(DaoInformePension daoInformePension) {
        this.daoInformePension = daoInformePension;
    }

    public DtoInformePension ejecutar(Long idEstudiante) {
        return this.daoInformePension.listarPorIdEstudiante(idEstudiante);
    }
}
