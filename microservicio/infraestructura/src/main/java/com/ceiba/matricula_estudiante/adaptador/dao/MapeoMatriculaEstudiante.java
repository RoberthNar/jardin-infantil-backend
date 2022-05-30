package com.ceiba.matricula_estudiante.adaptador.dao;

import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoMatriculaEstudiante implements RowMapper<DtoMatriculaEstudiante>, MapperResult{

    @Override
    public DtoMatriculaEstudiante mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idEstudiante = resultSet.getLong("id_estudiante");
        String nombreEstudiante = resultSet.getString("nombre_estudiante");
        Long idDocenteSala = resultSet.getLong("id_docente_sala");
        String nombreSala = resultSet.getString("nombre_sala");
        String nombreDocente = resultSet.getString("nombre_docente");
        String jornada = resultSet.getString("jornada");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "fecha_ingreso");

        return new DtoMatriculaEstudiante(id, idEstudiante, nombreEstudiante, idDocenteSala, nombreSala, nombreDocente, jornada, fechaIngreso);
    }

}
