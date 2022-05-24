package com.ceiba.estudiante.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

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
            "El estudiante no puede ser mayor a 5 anios de edad";

    private static final int EDAD_MINIMA_DE_INGRESO_EN_MESES = 8;
    private static final int EDAD_MAXIMA_DE_INGRESO_EN_ANIOS = 5;


    private Long id;
    private String nombreEstudiante;
    private LocalDate fechaNacimiento;
    private String nombreAcudiente;

    public Estudiante(Long id, String nombreEstudiante, LocalDate fechaNacimiento, String nombreAcudiente) {
        validarObligatorio(nombreEstudiante, SE_DEBE_INGRESAR_NOMBRE_DEL_ESTUDIANTE);
        validarObligatorio(nombreAcudiente, SE_DEBE_INGRESAR_NOMBRE_DEL_ACUDIENTE);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_DEL_ESTUDIANTE);

        validarEdadNoPuedeSerMenorOchoMeses(fechaNacimiento, EL_ESTUDIANTE_NO_PUEDE_SER_MENOR_A_8_MESES_DE_EDAD);
        validarEdadNoPuedeSerMayorCincoAnios(fechaNacimiento, EL_ESTUDIANTE_NO_PUEDE_SER_MAYOR_A_5_ANIOS_DE_EDAD);
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreAcudiente = nombreAcudiente;
    }

    public static void validarEdadNoPuedeSerMenorOchoMeses(LocalDate fechaNacimiento, String mensaje) {
        LocalDate fechaActual =  LocalDate.now();
        Long mesesEdad = ChronoUnit.MONTHS.between(fechaNacimiento, fechaActual);
        if (mesesEdad < EDAD_MINIMA_DE_INGRESO_EN_MESES) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarEdadNoPuedeSerMayorCincoAnios(LocalDate fechaNacimiento, String mensaje) {
        LocalDate fechaActual =  LocalDate.now();
        Long aniosEdad = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        if (aniosEdad > EDAD_MAXIMA_DE_INGRESO_EN_ANIOS) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
}
