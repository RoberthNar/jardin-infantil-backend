package com.ceiba.estudiante.adaptador.dao;

import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoEstudiante implements RowMapper<DtoEstudiante>, MapperResult {

    @Override
    public DtoEstudiante mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombreEstudiante = resultSet.getString("nombre_estudiante");
        LocalDate fechaNacimiento = extraerLocalDate(resultSet, "fecha_nacimiento");
        String nombreAcudiente =  resultSet.getString("nombre_acudiente");

        return new DtoEstudiante(id, nombreEstudiante, fechaNacimiento, nombreAcudiente);
    }

}
