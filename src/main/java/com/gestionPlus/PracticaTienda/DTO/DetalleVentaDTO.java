package com.gestionPlus.PracticaTienda.DTO;

import lombok.Data;

import java.util.List;

@Data
public class DetalleVentaDTO {
    // private Long id_detalle_venta;
    private Float subTotal;
    private int cantidad;
    private Float precioProducto;
    private String nombreProducto;
    private String descripcionProducto;

    public DetalleVentaDTO(Float total, int cantidad, Float precioProducto, String nombreProducto, String descripcionProducto) {
        this.subTotal = total;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
    }

}
