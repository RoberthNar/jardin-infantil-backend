package com.ceiba.pension.controlador;

import com.ceiba.pension.consulta.ManejadorListarPensionEstudiantePorId;
import com.ceiba.pension.modelo.dto.DtoInformePension;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pensiones")
public class ConsultaControladorInformePension {

    private final ManejadorListarPensionEstudiantePorId manejadorListarPensionEstudiantePorId;

    public ConsultaControladorInformePension(ManejadorListarPensionEstudiantePorId manejadorListarPensionEstudiantePorId) {
        this.manejadorListarPensionEstudiantePorId = manejadorListarPensionEstudiantePorId;
    }

    @GetMapping(value = "/{idEstudiante}")
    public DtoInformePension listarPorIdEstudiante(@PathVariable Long idEstudiante) {
        return this.manejadorListarPensionEstudiantePorId.ejecutar(idEstudiante);
    }

}
