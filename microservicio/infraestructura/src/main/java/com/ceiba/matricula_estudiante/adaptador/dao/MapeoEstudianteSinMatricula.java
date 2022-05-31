package com.ceiba.matricula_estudiante.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.matricula_estudiante.modelo.dto.DtoEstudianteSinMatricula;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEstudianteSinMatricula implements RowMapper<DtoEstudianteSinMatricula>, MapperResult{

    @Override
    public DtoEstudianteSinMatricula mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idEstudiante = resultSet.getLong("id_estudiante");
        String nombreEstudiante = resultSet.getString("nombre_estudiante");

        return new DtoEstudianteSinMatricula(id, idEstudiante, nombreEstudiante);
    }

}
