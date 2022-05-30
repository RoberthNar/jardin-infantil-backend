package com.ceiba.matricula_estudiante.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.repositorio.RepositorioMatriculaEstudiante;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMatriculaEstudianteMysql implements RepositorioMatriculaEstudiante {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "matricula_estudiante", value = "crear")
    private static String sqlCrearMatriculaEstudiante;

    @SqlStatement(namespace = "matricula_estudiante", value = "actualizar")
    private static String sqlActualizarMatriculaEstudiante;

    @SqlStatement(namespace = "matricula_estudiante", value = "eliminar")
    private static String sqlEliminarMatriculaEstudiante;

    @SqlStatement(namespace = "matricula_estudiante", value = "existePorId")
    private static String sqlExisteMatriculaEstudiantePorId;

    public RepositorioMatriculaEstudianteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(MatriculaEstudiante matriculaEstudiante) {
        return this.customNamedParameterJdbcTemplate.crear(matriculaEstudiante, sqlCrearMatriculaEstudiante);
    }

    @Override
    public void actualizar(MatriculaEstudiante matriculaEstudiante) {
        this.customNamedParameterJdbcTemplate.actualizar(matriculaEstudiante, sqlActualizarMatriculaEstudiante);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .update(sqlEliminarMatriculaEstudiante, paramSource);
    }

    @Override
    public boolean existePorId(Long idEstudiante) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEstudiante", idEstudiante);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteMatriculaEstudiantePorId, paramSource, Boolean.class);
    }

}
