package com.gestionPlus.PracticaTienda.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    private String fecha;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;
    private String categoria;
    @OneToMany(mappedBy = "idVenta")
    private List<DetalleVenta> detalleVentas;
}
