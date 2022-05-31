package com.ceiba.pension.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pension.modelo.entidad.Pension;
import com.ceiba.pension.puerto.repositorio.RepositorioPension;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPensionMysql implements RepositorioPension {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pension", value = "crear")
    private static String sqlCrearPension;

    @SqlStatement(namespace = "pension", value = "actualizar")
    private static String sqlActualizarPension;

    @SqlStatement(namespace = "pension", value = "eliminar")
    private static String sqlEliminarPension;

    @SqlStatement(namespace = "pension", value = "existePorId")
    private static String sqlExistePensionPorId;


    public RepositorioPensionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Pension pension) {
        return this.customNamedParameterJdbcTemplate.crear(pension, sqlCrearPension);
    }

    @Override
    public void actualizar(Pension pension) {
        this.customNamedParameterJdbcTemplate.actualizar(pension, sqlActualizarPension);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .update(sqlEliminarPension, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExistePensionPorId, paramSource, Boolean.class);
    }
}
