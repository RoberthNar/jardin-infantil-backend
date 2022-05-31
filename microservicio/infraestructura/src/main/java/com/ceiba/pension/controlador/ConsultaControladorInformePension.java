package com.ceiba.pension.controlador;

import com.ceiba.pension.consulta.ManejadorListarInformePensionEstudiantes;
import com.ceiba.pension.consulta.ManejadorListarPensionEstudiantePorId;
import com.ceiba.pension.modelo.dto.DtoInformePension;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pensiones")
public class ConsultaControladorInformePension {

    private final ManejadorListarPensionEstudiantePorId manejadorListarPensionEstudiantePorId;
    private final ManejadorListarInformePensionEstudiantes manejadorListarInformePensionEstudiantes;

    public ConsultaControladorInformePension(ManejadorListarPensionEstudiantePorId manejadorListarPensionEstudiantePorId,
                                             ManejadorListarInformePensionEstudiantes manejadorListarInformePensionEstudiantes) {
        this.manejadorListarPensionEstudiantePorId = manejadorListarPensionEstudiantePorId;
        this.manejadorListarInformePensionEstudiantes = manejadorListarInformePensionEstudiantes;
    }

    @GetMapping(value = "/{idEstudiante}")
    public DtoInformePension listarPorIdEstudiante(@PathVariable Long idEstudiante) {
        return this.manejadorListarPensionEstudiantePorId.ejecutar(idEstudiante);
    }
    @GetMapping
    public List<DtoInformePension> listarInforme() {
        return this.manejadorListarInformePensionEstudiantes.ejecutar();
    }


}
