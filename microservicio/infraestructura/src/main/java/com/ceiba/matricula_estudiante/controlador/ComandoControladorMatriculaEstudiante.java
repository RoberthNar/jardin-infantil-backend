package com.ceiba.matricula_estudiante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.matricula_estudiante.comando.ComandoMatriculaEstudiante;
import com.ceiba.matricula_estudiante.comando.manejador.ManejadorActualizarMatriculaEstudiante;
import com.ceiba.matricula_estudiante.comando.manejador.ManejadorCrearMatriculaEstudiante;
import com.ceiba.matricula_estudiante.comando.manejador.ManejadorEliminarMatriculaEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-estudiantes")
public class ComandoControladorMatriculaEstudiante {


    private final ManejadorCrearMatriculaEstudiante manejadorCrearMatriculaEstudiante;
    private final ManejadorEliminarMatriculaEstudiante manejadorEliminarMatriculaEstudiante;
    private final ManejadorActualizarMatriculaEstudiante manejadorActualizarMatriculaEstudiante;

    @Autowired
    public ComandoControladorMatriculaEstudiante(ManejadorCrearMatriculaEstudiante manejadorCrearMatriculaEstudiante,
                                                 ManejadorEliminarMatriculaEstudiante manejadorEliminarMatriculaEstudiante,
                                                 ManejadorActualizarMatriculaEstudiante manejadorActualizarMatriculaEstudiante) {
        this.manejadorCrearMatriculaEstudiante = manejadorCrearMatriculaEstudiante;
        this.manejadorEliminarMatriculaEstudiante = manejadorEliminarMatriculaEstudiante;
        this.manejadorActualizarMatriculaEstudiante = manejadorActualizarMatriculaEstudiante;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMatriculaEstudiante comandoMatriculaEstudiante) {
        return manejadorCrearMatriculaEstudiante.ejecutar(comandoMatriculaEstudiante);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarMatriculaEstudiante.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    public void actualizar(@RequestBody ComandoMatriculaEstudiante comandoMatriculaEstudiante,@PathVariable Long id) {
        comandoMatriculaEstudiante.setId(id);
        manejadorActualizarMatriculaEstudiante.ejecutar(comandoMatriculaEstudiante);
    }
}
