package com.gestionPlus.PracticaTienda.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Cliente {
    @Id
    private String cedula;
    private String nombre, telefono;
    // Relación uno a muchos con Venta
    @OneToMany(mappedBy = "idCliente")
    private List<Venta> ventas;

}
