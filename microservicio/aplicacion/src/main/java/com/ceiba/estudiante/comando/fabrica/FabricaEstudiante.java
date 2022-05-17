package com.ceiba.estudiante.comando.fabrica;

import com.ceiba.estudiante.comando.ComandoEstudiante;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class FabricaEstudiante {

    public Estudiante crear(ComandoEstudiante comandoEstudiante) {
        return new Estudiante(comandoEstudiante.getId(),
                comandoEstudiante.getNombreEstudiante(),
                comandoEstudiante.getFechaNacimiento(),
                comandoEstudiante.getNombreAcudiente());
    }
}
