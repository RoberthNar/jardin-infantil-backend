package com.ceiba.estudiante;

import java.math.BigDecimal;

public class ProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private Boolean aplicaIva;
    private BigDecimal valor;

    public ProductoTestDataBuilder conProductoPorDefecto(){
        this.id = 1l;
        this.nombre = "Cliente 1";
        this.aplicaIva = false;
        this.valor = BigDecimal.valueOf(1000);
        return this;
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conAplicaIva(Boolean aplicaIva) {
        this.aplicaIva = aplicaIva;
        return this;
    }

    public ProductoTestDataBuilder conValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }
}
