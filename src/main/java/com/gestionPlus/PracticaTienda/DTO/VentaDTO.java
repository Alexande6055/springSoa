package com.gestionPlus.PracticaTienda.DTO;

import lombok.Data;

import java.util.List;

@Data
public class VentaDTO {
    private Long id_venta;
    private String fecha;
    private String categoria;
    private List<DetalleVentaDTO> detalleVentaDTO;
    private Float total;

    public VentaDTO(Long id_venta, String fecha, String categoria) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    public void calcularTotal() {
        total = 0f;
        if (detalleVentaDTO != null && !detalleVentaDTO.isEmpty()) {
            for (DetalleVentaDTO detalleVentaDTO : detalleVentaDTO) {
                this.total += detalleVentaDTO.getSubTotal();
            }
        }
    }
}
