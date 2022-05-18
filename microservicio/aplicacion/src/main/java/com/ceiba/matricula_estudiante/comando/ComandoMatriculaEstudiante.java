package com.ceiba.matricula_estudiante.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMatriculaEstudiante {
    private Long id;
    private Long idEstudiante;
    private Long idDocenteSala;
    private String jornada;
    private LocalDate fechaIngreso;
}
