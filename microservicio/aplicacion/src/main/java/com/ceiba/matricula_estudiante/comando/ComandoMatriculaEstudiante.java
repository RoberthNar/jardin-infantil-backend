package com.ceiba.matricula_estudiante.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMatriculaEstudiante {
    private Long id;
    private Long idEstudiante;
    private String jornada;
    private LocalDate fechaIngreso;
}
