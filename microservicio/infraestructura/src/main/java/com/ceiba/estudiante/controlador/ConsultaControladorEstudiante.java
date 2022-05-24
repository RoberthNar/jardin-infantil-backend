package com.ceiba.estudiante.controlador;


import com.ceiba.estudiante.consulta.ManejadorListarEstudiantePorId;
import com.ceiba.estudiante.consulta.ManejadorListarEstudiantePorNombre;
import com.ceiba.estudiante.consulta.ManejadorListarEstudiantes;
import com.ceiba.estudiante.modelo.dto.DtoEstudiante;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class ConsultaControladorEstudiante {

    private final ManejadorListarEstudiantePorNombre manejadorListarEstudiantePorNombre;
    private final ManejadorListarEstudiantePorId manejadorListarEstudiantePorId;
    private final ManejadorListarEstudiantes manejadorListarEstudiantes;

    public ConsultaControladorEstudiante(ManejadorListarEstudiantePorNombre manejadorListarEstudiantePorNombre,
                                         ManejadorListarEstudiantes manejadorListarEstudiantes,
                                         ManejadorListarEstudiantePorId manejadorListarEstudiantePorId) {
        this.manejadorListarEstudiantePorNombre = manejadorListarEstudiantePorNombre;
        this.manejadorListarEstudiantePorId = manejadorListarEstudiantePorId;
        this.manejadorListarEstudiantes = manejadorListarEstudiantes;
    }

    @GetMapping
    public List<DtoEstudiante> listar() {
        return this.manejadorListarEstudiantes.ejecutar();
    }

    @GetMapping(value = "/nombre/{nombreEstudiante}")
    public List<DtoEstudiante> listarPorNombre(@PathVariable String nombreEstudiante) {
        return this.manejadorListarEstudiantePorNombre.ejecutar(nombreEstudiante);
    }

    @GetMapping(value = "/id/{idEstudiante}")
    public List<DtoEstudiante> listarPorId(@PathVariable Long idEstudiante) {
        return this.manejadorListarEstudiantePorId.ejecutar(idEstudiante);
    }

}
