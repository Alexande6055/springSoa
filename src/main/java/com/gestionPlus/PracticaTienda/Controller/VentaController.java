package com.gestionPlus.PracticaTienda.Controller;

import com.gestionPlus.PracticaTienda.DTO.ClienteDTO;
import com.gestionPlus.PracticaTienda.DTO.DetalleVentaDTO;
import com.gestionPlus.PracticaTienda.DTO.VentaDTO;
import com.gestionPlus.PracticaTienda.Entity.DetalleVenta;
import com.gestionPlus.PracticaTienda.Entity.Venta;
import com.gestionPlus.PracticaTienda.Repository.DetalleVentaRepository;
import com.gestionPlus.PracticaTienda.Service.ClienteService;
import com.gestionPlus.PracticaTienda.Service.DetalleVentaService;
import com.gestionPlus.PracticaTienda.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @Autowired
    private DetalleVentaService detalleVentaService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/totalVentas")
    public Object obtenerTotal() {
        return detalleVentaService.obtenerTotalVentas();
   }


    @GetMapping("/categoria={categoria}")
    public List<VentaDTO> obtenerPorCategoria(@PathVariable String categoria) {
        List<VentaDTO> ventaDTOS = ventaService.obtenerVentaPorCategoria(categoria);
        return ventaDTOS;
    }
/*//
    @GetMapping("/detalleVenta={id_venta}")
    public List<DetalleVentaDTO> obtenerDetalle(@PathVariable Long id_venta) {
        return detalleVentaService.obtenerListaDetalleVenta(id_venta);
    }
*/
    @GetMapping("/clienteMasComprado")
    public List<Object> obtenerClienteComprado() {
        return clienteService.obtenerClienteCompras();
    }

}
