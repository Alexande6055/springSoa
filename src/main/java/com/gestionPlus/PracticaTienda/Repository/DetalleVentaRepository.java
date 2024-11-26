package com.gestionPlus.PracticaTienda.Repository;

import com.gestionPlus.PracticaTienda.DTO.DetalleVentaDTO;
import com.gestionPlus.PracticaTienda.Entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {

    @Query("SELECT SUM(dv.subTotal) AS total FROM  DetalleVenta dv")
    Object reporteVentasTotales();

  @Query("SELECT new com.gestionPlus.PracticaTienda.DTO.DetalleVentaDTO(dv.subTotal,dv.cantidad,p.precio,p.nombre,p.descripcion) FROM  DetalleVenta dv INNER JOIN Producto p ON dv.idProducto.id_producto=p.id_producto WHERE dv.idVenta.id_venta=:id_venta")
    List<DetalleVentaDTO> reporteListaDetalleVenta(@Param("id_venta") Long id_venta);
}
