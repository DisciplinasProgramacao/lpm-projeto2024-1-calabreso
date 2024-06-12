package com.calabreso.restaurante.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calabreso.restaurante.entity.Cliente;

@RestController
@RequestMapping(path = "/")
public class ClienteController {

    @GetMapping
    public List<Cliente> getCliente(){
        return List.of(
            new Cliente("Pedro")
        );
    }
    
}
