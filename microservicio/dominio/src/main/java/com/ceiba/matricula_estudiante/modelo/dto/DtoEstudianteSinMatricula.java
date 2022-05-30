package com.ceiba.matricula_estudiante.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoEstudianteSinMatricula {

    private Long id;
    private Long idEstudiante;
    private String nombreEstudiante;
}
