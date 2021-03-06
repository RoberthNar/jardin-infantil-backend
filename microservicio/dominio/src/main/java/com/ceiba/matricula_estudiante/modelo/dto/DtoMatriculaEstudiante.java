package com.ceiba.matricula_estudiante.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoMatriculaEstudiante {

    private Long id;
    private Long idEstudiante;
    private String nombreEstudiante;
    private Long idDocenteSala;
    private String nombreSala;
    private String nombreDocente;
    private String jornada;
    private LocalDate fechaIngreso;

}
