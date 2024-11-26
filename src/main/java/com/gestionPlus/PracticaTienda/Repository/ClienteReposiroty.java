package com.gestionPlus.PracticaTienda.Repository;

import com.gestionPlus.PracticaTienda.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteReposiroty extends JpaRepository<Cliente, String> {

    // @Query("SELECT c.nombre FROM Cliente c ")
    @Query("SELECT c.nombre,c.cedula,COUNT(v.idCliente.cedula)AS compras_realizadas FROM Cliente c INNER JOIN Venta v ON c.cedula=v.idCliente.cedula GROUP BY c.cedula ORDER BY compras_realizadas DESC LIMIT 1 ")
    List<Object> clienteConMasCompras();
}
