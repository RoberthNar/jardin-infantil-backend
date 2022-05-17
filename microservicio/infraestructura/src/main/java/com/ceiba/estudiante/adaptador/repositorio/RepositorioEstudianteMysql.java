package com.ceiba.estudiante.adaptador.repositorio;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEstudianteMysql implements RepositorioEstudiante {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "estudiante", value = "crear")
    private static String sqlCrearEstudiante;

    @SqlStatement(namespace = "estudiante", value = "actualizar")
    private static String sqlActualizarEstudiante;

    @SqlStatement(namespace = "estudiante", value = "eliminar")
    private static String sqlEliminarEstudiante;

    @SqlStatement(namespace = "estudiante", value = "existePorId")
    private static String sqlExisteEstudiantePorId;

    @SqlStatement(namespace = "estudiante", value = "existe")
    private static String sqlExisteEstudiante;

    public RepositorioEstudianteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Estudiante estudiante) {
        return this.customNamedParameterJdbcTemplate.crear(estudiante, sqlCrearEstudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.customNamedParameterJdbcTemplate.actualizar(estudiante, sqlActualizarEstudiante);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .update(sqlEliminarEstudiante, paramSource);
    }

    @Override
    public boolean existe(String nombreEstudiante) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombreEstudiante);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteEstudiante, paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteEstudiantePorId, paramSource, Boolean.class);
    }
}
