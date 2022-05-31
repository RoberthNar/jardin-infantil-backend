package com.ceiba.pension.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoInformePension {

    private Long id;
    private String nombreEstudiante;
    private LocalDate fechaNacimiento;
    private String nombreAcudiente;
    private String nombreDocente;
    private String nombreSala;
    private String jornada;
    private int horasMulta;
    private LocalDate mesPagado;
    private Double valorTotal;
}
