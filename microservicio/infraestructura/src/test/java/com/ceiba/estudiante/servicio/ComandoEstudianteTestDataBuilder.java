package com.ceiba.estudiante.servicio;

import com.ceiba.estudiante.comando.ComandoEstudiante;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoEstudianteTestDataBuilder {

    private Long id;
    private String nombreEstudiante;
    private LocalDate fechaNacimiento;
    private String nombreAcudiente;

    public ComandoEstudianteTestDataBuilder() {
        this.nombreEstudiante = UUID.randomUUID().toString().substring(0,20);
        this.fechaNacimiento = LocalDate.now().plusMonths(-9);
        this.nombreAcudiente = UUID.randomUUID().toString().substring(0,20);
    }

    public ComandoEstudiante build() {
        return new ComandoEstudiante(id, nombreEstudiante, fechaNacimiento, nombreAcudiente);
    }
}
