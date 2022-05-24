package com.ceiba.matricula_estudiante.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.dao.DaoMatriculaEstudiante;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DaoMatriculaEstudianteMysql implements DaoMatriculaEstudiante {


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "matricula_estudiante", value = "listarPorIdEstudiante")
    private static String sqlListarPorIdEstudiante;

    public DaoMatriculaEstudianteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMatriculaEstudiante> listarPorIdEstudiante(Long idEstudiante) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEstudiante", idEstudiante);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlListarPorIdEstudiante, paramSource, new MapeoMatriculaEstudiante());
    }

}
