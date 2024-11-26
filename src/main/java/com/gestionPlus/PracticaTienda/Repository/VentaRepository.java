package com.gestionPlus.PracticaTienda.Repository;

import com.gestionPlus.PracticaTienda.DTO.ClienteDTO;
import com.gestionPlus.PracticaTienda.DTO.VentaDTO;
import com.gestionPlus.PracticaTienda.Entity.Cliente;
import com.gestionPlus.PracticaTienda.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

     @Query("SELECT new com.gestionPlus.PracticaTienda.DTO.VentaDTO(v.id_venta,v.fecha,v.categoria) FROM Venta v WHERE v.categoria=:categoria")
    List<VentaDTO> reporteVentasPorCategoria(@Param("categoria") String categoria);

}
