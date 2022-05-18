package com.ceiba.estudiante.servicio.testdatabuilder;

import com.ceiba.estudiante.modelo.entidad.Estudiante;

import java.time.LocalDate;
import java.util.UUID;

public class EstudianteTestDataBuilder {

    private Long id;
    private String nombreEstudiante;
    private LocalDate fechaNacimiento;
    private String nombreAcudiente;


    public EstudianteTestDataBuilder() {
        this.nombreEstudiante = "Estudiante Test 1";
        this.fechaNacimiento = LocalDate.now().plusMonths(-9);
        this.nombreAcudiente = "Acudiente Test 1";
    }

    public EstudianteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public EstudianteTestDataBuilder conNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        return this;
    }

    public EstudianteTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public EstudianteTestDataBuilder conNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
        return this;
    }

    public Estudiante build() {
        return new Estudiante(id, nombreEstudiante, fechaNacimiento, nombreAcudiente);
    }
}
