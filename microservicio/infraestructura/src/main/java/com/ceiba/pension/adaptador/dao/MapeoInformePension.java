package com.ceiba.pension.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pension.modelo.dto.DtoInformePension;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoInformePension implements RowMapper<DtoInformePension>, MapperResult {

    @Override
    public DtoInformePension mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombreEstudiante = resultSet.getString("nombre_estudiante");
        LocalDate fechaNacimiento = extraerLocalDate(resultSet, "fecha_nacimiento");
        String nombreAcudiente = resultSet.getString("nombre_acudiente");
        String nombreDocente = resultSet.getString("nombre_docente");
        String nombreSala = resultSet.getString("nombre_sala");
        String jornada = resultSet.getString("jornada");
        int horasMulta = resultSet.getInt("horas_multa");
        LocalDate mesPagado = extraerLocalDate(resultSet, "mes_pagado");
        double valorTotal = resultSet.getInt("valor_total");


        return new DtoInformePension(id, nombreEstudiante, fechaNacimiento, nombreAcudiente, nombreDocente,
                nombreSala, jornada, horasMulta, mesPagado, valorTotal);
    }
}
