package com.ceiba.estudiante.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Estudiante {

    private static final String SE_DEBE_INGRESAR_NOMBRE_DEL_ESTUDIANTE = "Se debe ingresar el nombre del estudiante";
    private static final String SE_DEBE_INGRESAR_NOMBRE_DEL_ACUDIENTE = "Se debe ingresar el nombre del acudiente";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_DEL_ESTUDIANTE =
            "Se debe ingresar la feha de nacimiento del estudiante";

    private static final String EL_ESTUDIANTE_NO_PUEDE_SER_MENOR_A_8_MESES_DE_EDAD =
            "El estudiante no puede ser menor a 8 meses de edad";
    private static final String EL_ESTUDIANTE_NO_PUEDE_SER_MAYOR_A_5_ANIOS_DE_EDAD =
            "El estudiante no puede ser mayor a 5 años de edad";


    private Long id;
    private String nombreEstudiante;
    private LocalDate fechaNacimiento;
    private String nombreAcudiente;

    public Estudiante(Long id, String nombreEstudiante, LocalDate fechaNacimiento, String nombreAcudiente) {
        validarObligatorio(nombreEstudiante, SE_DEBE_INGRESAR_NOMBRE_DEL_ESTUDIANTE);
        validarObligatorio(nombreAcudiente, SE_DEBE_INGRESAR_NOMBRE_DEL_ACUDIENTE);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_DEL_ESTUDIANTE);
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreAcudiente = nombreAcudiente;
    }
}
