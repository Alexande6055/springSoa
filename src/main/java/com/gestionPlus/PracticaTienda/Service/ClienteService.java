package com.gestionPlus.PracticaTienda.Service;

import com.gestionPlus.PracticaTienda.Repository.ClienteReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteReposiroty clienteReposiroty;

    public List<Object> obtenerClienteCompras(){
       return clienteReposiroty.clienteConMasCompras();
    }
}
