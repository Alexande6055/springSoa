package com.gestionPlus.PracticaTienda.Service;

import com.gestionPlus.PracticaTienda.DTO.ClienteDTO;
import com.gestionPlus.PracticaTienda.DTO.DetalleVentaDTO;
import com.gestionPlus.PracticaTienda.DTO.VentaDTO;
import com.gestionPlus.PracticaTienda.Entity.Venta;
import com.gestionPlus.PracticaTienda.Repository.DetalleVentaRepository;
import com.gestionPlus.PracticaTienda.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<VentaDTO> obtenerVentaPorCategoria(String categoria){
        List<VentaDTO> objects = ventaRepository.reporteVentasPorCategoria(categoria);
        for(VentaDTO ventaDTO:objects){
            List<DetalleVentaDTO> detalleVentaDTOS = detalleVentaRepository.reporteListaDetalleVenta(ventaDTO.getId_venta());
            ventaDTO.setDetalleVentaDTO(detalleVentaDTOS);
            ventaDTO.calcularTotal();
        }
        return objects;
   }
}
