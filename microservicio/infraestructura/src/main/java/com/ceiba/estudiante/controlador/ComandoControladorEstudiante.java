package com.ceiba.estudiante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.estudiante.comando.ComandoEstudiante;
import com.ceiba.estudiante.comando.manejador.ManejadorActualizarEstudiante;
import com.ceiba.estudiante.comando.manejador.ManejadorCrearEstudiante;
import com.ceiba.estudiante.comando.manejador.ManejadorEliminarEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class ComandoControladorEstudiante {


    private final ManejadorCrearEstudiante manejadorCrearEstudiante;
    private final ManejadorEliminarEstudiante manejadorEliminarEstudiante;
    private final ManejadorActualizarEstudiante manejadorActualizarEstudiante;

    @Autowired
    public ComandoControladorEstudiante(ManejadorCrearEstudiante manejadorCrearEstudiante,
                                    ManejadorEliminarEstudiante manejadorEliminarEstudiante,
                                    ManejadorActualizarEstudiante manejadorActualizarEstudiante) {
        this.manejadorCrearEstudiante = manejadorCrearEstudiante;
        this.manejadorEliminarEstudiante = manejadorEliminarEstudiante;
        this.manejadorActualizarEstudiante = manejadorActualizarEstudiante;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEstudiante comandoEstudiante) {
        return manejadorCrearEstudiante.ejecutar(comandoEstudiante);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarEstudiante.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    public void actualizar(@RequestBody ComandoEstudiante comandoEstudiante,@PathVariable Long id) {
        comandoEstudiante.setId(id);
        manejadorActualizarEstudiante.ejecutar(comandoEstudiante);
    }

}
