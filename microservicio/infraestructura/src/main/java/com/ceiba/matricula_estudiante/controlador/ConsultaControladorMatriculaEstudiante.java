package com.ceiba.matricula_estudiante.controlador;


import com.ceiba.estudiante.consulta.ManejadorListarEstudiantePorNombre;
import com.ceiba.estudiante.consulta.ManejadorListarEstudiantes;
import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import com.ceiba.matricula_estudiante.consulta.ManejadorListarMatriculaEstudiantePorIdEstudiante;
import com.ceiba.matricula_estudiante.modelo.dto.DtoMatriculaEstudiante;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matricula-estudiantes")
public class ConsultaControladorMatriculaEstudiante {

    private final ManejadorListarMatriculaEstudiantePorIdEstudiante manejadorListarMatriculaEstudiantePorIdEstudiante;

    public ConsultaControladorMatriculaEstudiante(ManejadorListarMatriculaEstudiantePorIdEstudiante manejadorListarMatriculaEstudiantePorIdEstudiante) {
        this.manejadorListarMatriculaEstudiantePorIdEstudiante = manejadorListarMatriculaEstudiantePorIdEstudiante;
    }

    @GetMapping(value = "/{idEstudiante}")
    public DtoMatriculaEstudiante listarPorIdEstudiante(@PathVariable Long idEstudiante) {
        return this.manejadorListarMatriculaEstudiantePorIdEstudiante.ejecutar(idEstudiante);
    }

}
