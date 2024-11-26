package com.gestionPlus.PracticaTienda.DTO;

import lombok.Data;

@Data
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private Float precio;

    public ProductoDTO(String nombre, String descripcion, Float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
