package com.ceiba.pension.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPension {
    private Long id;
    private Long idEstudiante;
    private Integer horasMulta;
    private LocalDate mesPagado;
    private Double valorTotal;
}
