package com.ceiba.pension.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pension.comando.ComandoPension;
import com.ceiba.pension.comando.manejador.ManejadorActualizarPension;
import com.ceiba.pension.comando.manejador.ManejadorCrearPension;
import com.ceiba.pension.comando.manejador.ManejadorEliminarPension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculo-pensiones")
public class ComandoControladorPension {


    private final ManejadorCrearPension manejadorCrearPension;
    private final ManejadorEliminarPension manejadorEliminarPension;
    private final ManejadorActualizarPension manejadorActualizarPension;

    @Autowired
    public ComandoControladorPension(ManejadorCrearPension manejadorCrearPension,
                                     ManejadorEliminarPension manejadorEliminarPension,
                                     ManejadorActualizarPension manejadorActualizarPension) {
        this.manejadorCrearPension = manejadorCrearPension;
        this.manejadorEliminarPension = manejadorEliminarPension;
        this.manejadorActualizarPension = manejadorActualizarPension;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPension comandoPension) {
        return manejadorCrearPension.ejecutar(comandoPension);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPension.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    public void actualizar(@RequestBody ComandoPension comandoPension,@PathVariable Long id) {
        comandoPension.setId(id);
        manejadorActualizarPension.ejecutar(comandoPension);
    }

}
