package com.ceiba.estudiante.modelo.entidad;

import java.time.LocalDateTime;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Estudiante {

    private static final String SE_DEBE_INGRESAR_NOMBRE_DEL_ESTUDIANTE = "Se debe ingresar el nombre del estudiante";
    private static final String SE_DEBE_INGRESAR_NOMBRE_DEL_ACUDIENTE = "Se debe ingresar el nombre del acudiente";
    private static final String EL_ESTUDIANTE_NO_PUEDE_SER_MENOR_A_8_MESES_DE_EDAD = "El estudiante no puede ser menor a 8 meses de edad";
    private static final String EL_ESTUDIANTE_NO_PUEDE_SER_MAYOR_A_5_ANIOS_DE_EDAD = "El estudiante no puede ser mayor a 5 años de edad";


    private final Long id;
    private final String nombreEstudiante;
    private LocalDateTime fechaNacimiento;
    private final String nombreAcudiente;

    public Estudiante(Long id, String nombreEstudiante, LocalDateTime fechaNacimiento, String nombreAcudiente) {
        validarObligatorio(nombreEstudiante, SE_DEBE_INGRESAR_NOMBRE_DEL_ESTUDIANTE);
        validarObligatorio(nombreAcudiente, SE_DEBE_INGRESAR_NOMBRE_DEL_ACUDIENTE);
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreAcudiente = nombreAcudiente;
    }
}
