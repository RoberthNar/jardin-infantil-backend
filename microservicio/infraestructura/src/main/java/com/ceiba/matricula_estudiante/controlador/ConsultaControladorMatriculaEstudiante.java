package com.ceiba.matricula_estudiante.controlador;


import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import com.ceiba.matricula_estudiante.consulta.ManejadorListarEstudiantesSinMatricula;
import com.ceiba.matricula_estudiante.consulta.ManejadorListarMatriculaEstudiantePorIdEstudiante;
import com.ceiba.matricula_estudiante.consulta.ManejadorListarMatriculaEstudiantes;
import com.ceiba.matricula_estudiante.modelo.dto.DtoEstudianteSinMatricula;
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

    private final ManejadorListarMatriculaEstudiantes manejadorListarMatriculaEstudiantes;

    private final ManejadorListarEstudiantesSinMatricula manejadorListarEstudiantesSinMatricula;



    public ConsultaControladorMatriculaEstudiante(ManejadorListarMatriculaEstudiantePorIdEstudiante manejadorListarMatriculaEstudiantePorIdEstudiante,
                                                  ManejadorListarMatriculaEstudiantes manejadorListarMatriculaEstudiantes,
                                                  ManejadorListarEstudiantesSinMatricula manejadorListarEstudiantesSinMatricula) {
        this.manejadorListarMatriculaEstudiantePorIdEstudiante = manejadorListarMatriculaEstudiantePorIdEstudiante;
        this.manejadorListarMatriculaEstudiantes = manejadorListarMatriculaEstudiantes;
        this.manejadorListarEstudiantesSinMatricula = manejadorListarEstudiantesSinMatricula;
    }

    @GetMapping(value = "/{idEstudiante}")
    public DtoMatriculaEstudiante listarPorIdEstudiante(@PathVariable Long idEstudiante) {
        return this.manejadorListarMatriculaEstudiantePorIdEstudiante.ejecutar(idEstudiante);
    }

    @GetMapping
    public List<DtoMatriculaEstudiante> listar() {
        return this.manejadorListarMatriculaEstudiantes.ejecutar();
    }

    @GetMapping(value = "/estudiantes-sin-matricula")
    public List<DtoEstudianteSinMatricula> listarEstudiantesSinMatricula() {
        return this.manejadorListarEstudiantesSinMatricula.ejecutar();
    }

}
