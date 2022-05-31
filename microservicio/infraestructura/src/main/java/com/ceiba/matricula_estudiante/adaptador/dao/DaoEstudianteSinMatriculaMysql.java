package com.ceiba.matricula_estudiante.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.matricula_estudiante.modelo.dto.DtoEstudianteSinMatricula;
import com.ceiba.matricula_estudiante.puerto.dao.DaoEstudianteSinMatricula;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DaoEstudianteSinMatriculaMysql implements DaoEstudianteSinMatricula {


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "matricula_estudiante", value = "listarEstudiantesSinMatricula")
    private static String sqlListarEstudiantesSinMatricula;

    public DaoEstudianteSinMatriculaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public List<DtoEstudianteSinMatricula> listarEstudiantesSinMatricula() {
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlListarEstudiantesSinMatricula, new MapeoEstudianteSinMatricula());
    }

}
