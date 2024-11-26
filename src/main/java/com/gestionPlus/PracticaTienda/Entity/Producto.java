package com.gestionPlus.PracticaTienda.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private String nombre;
    private String descripcion;
    private Float precio;
    @OneToOne(mappedBy = "idProducto")
    private DetalleVenta detalleVentas;

}
