package com.gestionPlus.PracticaTienda.Service;

import com.gestionPlus.PracticaTienda.DTO.DetalleVentaDTO;
import com.gestionPlus.PracticaTienda.Entity.DetalleVenta;
import com.gestionPlus.PracticaTienda.Repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    public Object obtenerTotalVentas(){
        return detalleVentaRepository.reporteVentasTotales();
    }
    public List<DetalleVentaDTO> obtenerListaDetalleVenta(Long id_venta){
        return detalleVentaRepository.reporteListaDetalleVenta(id_venta);
    }
}
