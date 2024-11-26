package com.gestionPlus.PracticaTienda.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_venta;
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta idVenta;
    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto idProducto;
    private int cantidad;
    private Float subTotal;

}
