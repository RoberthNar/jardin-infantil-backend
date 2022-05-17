package com.ceiba.matricula_estudiante.modelo.entidad;

import java.time.LocalDateTime;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class MatriculaEstudiante {

    private static final String SE_DEBE_INGRESAR_LA_JORNADA_DEL_ESTUDIANTE = "Se debe ingresar la jornada del estudiante";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO_DEL_ESTUDIANTE = "Se debe ingresar la fecha de ingreso del estudiante";

    private final Long id;
    private final Long idEstudiante;
    private final Long idDocenteSala;
    private final String jornada;
    private LocalDateTime fechaIngreso;

    public MatriculaEstudiante(Long id, Long idEstudiante, Long idDocenteSala, String jornada, LocalDateTime fechaIngreso) {
        validarObligatorio(jornada, SE_DEBE_INGRESAR_LA_JORNADA_DEL_ESTUDIANTE);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO_DEL_ESTUDIANTE);
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idDocenteSala = idDocenteSala;
        this.jornada = jornada;
        this.fechaIngreso = fechaIngreso;
    }
}
