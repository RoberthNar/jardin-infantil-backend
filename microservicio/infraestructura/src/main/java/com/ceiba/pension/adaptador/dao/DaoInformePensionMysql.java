package com.ceiba.pension.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.matricula_estudiante.adaptador.dao.MapeoMatriculaEstudiante;
import com.ceiba.pension.modelo.dto.DtoInformePension;
import com.ceiba.pension.puerto.dao.DaoInformePension;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoInformePensionMysql implements DaoInformePension {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "informe_pension", value = "listarPorIdEstudiante")
    private static String sqlListarPorIdEstudiante;
    @SqlStatement(namespace = "informe_pension", value = "listarInforme")
    private static String sqlListarInforme;


    public DaoInformePensionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoInformePension listarPorIdEstudiante(Long idEstudiante) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEstudiante", idEstudiante);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlListarPorIdEstudiante, paramSource, new MapeoInformePension());
    }

    @Override
    public List<DtoInformePension> listarInforme() {
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlListarInforme, new MapeoInformePension());
    }
}
