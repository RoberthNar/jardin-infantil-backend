package com.ceiba.matricula_estudiante.modelo.entidad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class MatriculaEstudiante {

    private static final String SE_DEBE_INGRESAR_DATOS_DEL_ESTUDIANTE = "Se debe ingresar los datos del estudiante";
    private static final String SE_DEBE_INGRESAR_DATOS_DEL_SALON_DEL_ESTUDIANTE = "Se debe ingresar los datos del salón del estudiante";
    private static final String SE_DEBE_INGRESAR_LA_JORNADA_DEL_ESTUDIANTE = "Se debe ingresar la jornada del estudiante";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO_DEL_ESTUDIANTE = "Se debe ingresar la fecha de ingreso del estudiante";
    private static final String SE_DEBE_INGRESAR_UN_IDENTIFICADOR_DE_SALA_CORRECTO = "Se debe ingresar un identificador de sala correcto";
    private static final String SE_DEBE_INGRESAR_UNA_JORNADA_CORRECTA = "Se debe ingresar una jornada correcta";
    public static final String LA_FECHA_NO_PUEDE_SER_IGUAL_AL_DIA_DE_DESCANSO = "La fecha no puede ser igual al dia de descanso";
    public static final String LA_FECHA_NO_PUEDE_SER_MENOR_AL_DIA_ACTUAL = "La fecha no puede ser menor al dia de actual";


    private Long id;
    private Long idEstudiante;
    private Long idDocenteSala;
    private String jornada;
    private LocalDate fechaIngreso;

    public MatriculaEstudiante(Long id, Long idEstudiante, Long idDocenteSala, String jornada, LocalDate fechaIngreso) {
        validarObligatorio(jornada, SE_DEBE_INGRESAR_LA_JORNADA_DEL_ESTUDIANTE);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO_DEL_ESTUDIANTE);
        validarObligatorio(idEstudiante, SE_DEBE_INGRESAR_DATOS_DEL_ESTUDIANTE);
        validarObligatorio(idDocenteSala, SE_DEBE_INGRESAR_DATOS_DEL_SALON_DEL_ESTUDIANTE);

        validarIdentificadorSalaCorrecto(idDocenteSala, SE_DEBE_INGRESAR_UN_IDENTIFICADOR_DE_SALA_CORRECTO);
        validarJornadaCorrecto(jornada, SE_DEBE_INGRESAR_UNA_JORNADA_CORRECTA);
        validarFechaNoPuedeSerInferiorAlDiaDeHoy(fechaIngreso, LA_FECHA_NO_PUEDE_SER_MENOR_AL_DIA_ACTUAL);
        validarFechaNoPuedeSerIgualAlDiaDeDescanso(fechaIngreso, LA_FECHA_NO_PUEDE_SER_IGUAL_AL_DIA_DE_DESCANSO);


        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idDocenteSala = idDocenteSala;
        this.jornada = jornada;
        this.fechaIngreso = fechaIngreso;
    }

    public static void validarIdentificadorSalaCorrecto(Long idDocenteSala, String mensaje) {
        if (idDocenteSala < 1 || idDocenteSala > 5) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarJornadaCorrecto(String jornada, String mensaje) {
        if (!(jornada.toUpperCase().equals("MANIANA") || jornada.toUpperCase().equals("COMPLETA"))) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarFechaNoPuedeSerInferiorAlDiaDeHoy(LocalDate fechaIngreso, String mensaje) {
        if (fechaIngreso.isBefore(LocalDateTime.now().toLocalDate())) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarFechaNoPuedeSerIgualAlDiaDeDescanso(LocalDate fechaIngreso, String mensaje) {
        DayOfWeek diaDeLaSemana = fechaIngreso.getDayOfWeek();
        if (diaDeLaSemana == DayOfWeek.MONDAY) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
}
