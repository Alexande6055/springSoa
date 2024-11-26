package com.gestionPlus.PracticaTienda.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private String nombre;
    private String cedula;
    private String telefono;
    private List<VentaDTO> ventaDTO;

    public ClienteDTO(String nombre, String cedula, String telefono, List<VentaDTO> ventaDTO) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.ventaDTO = ventaDTO;
    }
}
