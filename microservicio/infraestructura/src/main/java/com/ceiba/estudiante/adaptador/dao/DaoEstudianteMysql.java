package com.ceiba.estudiante.adaptador.dao;

import com.ceiba.estudiante.puerto.dao.DaoEstudiante;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEstudianteMysql implements DaoEstudiante {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "estudiante", value = "listar")
    private static String sqlListarEstudiante;
    @SqlStatement(namespace = "estudiante", value = "listarPorNombre")
    private static String sqlListarPorNombre;
    @SqlStatement(namespace = "estudiante", value = "listarPorId")
    private static String sqlListarPorId;

    public DaoEstudianteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEstudiante> listar() {
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlListarEstudiante, new MapeoEstudiante());
    }

    @Override
    public List<DtoEstudiante> listarPorNombre(String nombreEstudiante) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombreEstudiante", nombreEstudiante);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlListarPorNombre, paramSource, new MapeoEstudiante());
    }
    @Override
    public DtoEstudiante listarPorId(Long idEstudiante) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEstudiante", idEstudiante);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlListarPorId, paramSource, new MapeoEstudiante());
    }

}
