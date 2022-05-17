package com.ceiba.estudiante.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEstudiante {
    private Long id;
    private String nombreEstudiante;
    private LocalDateTime fechaNacimento;
    private String nombreAcudiente;
}
