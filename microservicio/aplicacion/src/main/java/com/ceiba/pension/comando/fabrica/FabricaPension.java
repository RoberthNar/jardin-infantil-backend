package com.ceiba.pension.comando.fabrica;

import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.modelo.entidad.MatriculaEstudiante;
import com.ceiba.matricula_estudiante.puerto.dao.DaoMatriculaEstudiante;
import com.ceiba.pension.comando.ComandoPension;
import com.ceiba.pension.modelo.entidad.Pension;
import org.springframework.stereotype.Component;

@Component
public class FabricaPension {

    private static final double VALOR_PENSION_MANIANA = 250000;
    private static final double VALOR_PENSION_COMPLETA = 350000;
    private static final double VALOR_MULTA = 10000;
    private static final String JORNADA_MANIANA = "MANIANA";
    private static final String JORNADA_COMPLETA = "COMPLETA";

    private final DaoMatriculaEstudiante daoMatriculaEstudiante;

    public FabricaPension(DaoMatriculaEstudiante daoMatriculaEstudiante) {
        this.daoMatriculaEstudiante = daoMatriculaEstudiante;
    }

    public Pension crear(ComandoPension comandoPension) {
        return new Pension(comandoPension.getId(),
                comandoPension.getIdEstudiante(),
                comandoPension.getHorasMulta(),
                comandoPension.getMesPagado(),
                calcularPension(comandoPension));
    }

    private double calcularPension(ComandoPension comandoPension){
        DtoMatriculaEstudiante matriculaEstudiante = obtenerMatriculaEstudiante(comandoPension.getIdEstudiante());
        double pension = 0;
        int horasMultas = comandoPension.getHorasMulta();
        if (matriculaEstudiante.getJornada().equalsIgnoreCase(JORNADA_MANIANA)) {
            pension = VALOR_PENSION_MANIANA + (horasMultas * VALOR_MULTA);
        } else if (matriculaEstudiante.getJornada().equalsIgnoreCase(JORNADA_COMPLETA)) {
            pension = VALOR_PENSION_COMPLETA + (horasMultas * VALOR_MULTA);
        }
        return pension;
    }

    private DtoMatriculaEstudiante obtenerMatriculaEstudiante(Long idEstudiante) {
        DtoMatriculaEstudiante matriculaEstudiante = this.daoMatriculaEstudiante.listarPorIdEstudiante(idEstudiante);
        return  matriculaEstudiante;
    }
}
