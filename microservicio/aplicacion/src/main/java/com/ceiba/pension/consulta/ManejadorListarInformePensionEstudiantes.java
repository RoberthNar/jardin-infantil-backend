package com.ceiba.pension.consulta;

import com.ceiba.pension.modelo.dto.DtoInformePension;
import com.ceiba.pension.puerto.dao.DaoInformePension;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarInformePensionEstudiantes {

    private final DaoInformePension daoInformePension;

    public ManejadorListarInformePensionEstudiantes(DaoInformePension daoInformePension) {
        this.daoInformePension = daoInformePension;
    }

    public List<DtoInformePension> ejecutar() {
        return this.daoInformePension.listarInforme();
    }
}
