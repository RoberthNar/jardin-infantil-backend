package com.ceiba.pension.modelo.entidad;

import java.time.LocalDate;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Pension {

    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_ESTUDIANTE = "Se debe ingresar el ID del estudiante";
    private static final String SE_DEBE_INGRESAR_EL_MES_DE_PENSION_A_PAGAR = "Se debe ingresar el mes de pension a pagar";

    private Long id;
    private Long idEstudiante;
    private Integer horasMulta;
    private LocalDate mesPagado;
    private Double valorTotal;

    public Pension(Long id, Long idEstudiante, Integer horasMulta, LocalDate mesPagado, Double valorTotal) {
        validarObligatorio(idEstudiante, SE_DEBE_INGRESAR_EL_ID_DEL_ESTUDIANTE);
        validarObligatorio(mesPagado, SE_DEBE_INGRESAR_EL_MES_DE_PENSION_A_PAGAR);
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.horasMulta = horasMulta;
        this.mesPagado = mesPagado;
        this.valorTotal = valorTotal;
    }
}
