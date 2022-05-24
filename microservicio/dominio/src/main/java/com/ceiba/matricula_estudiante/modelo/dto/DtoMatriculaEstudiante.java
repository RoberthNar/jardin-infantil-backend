package com.ceiba.matricula_estudiante.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoMatriculaEstudiante {

    private Long id;
    private Long idEstudiante;
    private Long idDocenteSala;
    private String jornada;
    private LocalDate fechaIngreso;

}
