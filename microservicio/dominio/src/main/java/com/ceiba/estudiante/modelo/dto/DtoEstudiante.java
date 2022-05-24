package com.ceiba.estudiante.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoEstudiante {

    private Long id;
    private String nombreEstudiante;
    private LocalDate fechaNacimiento;
    private String nombreAcudiente;
}
