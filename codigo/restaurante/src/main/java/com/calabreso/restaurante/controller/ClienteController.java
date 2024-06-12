package com.calabreso.restaurante.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calabreso.restaurante.entity.Cliente;

@RestController
public class ClienteController {

    @PostMapping("/cliente/criar")
    public Cliente criarCliente(@RequestParam("nome") String nome) {
        return new Cliente(nome);
    }

    @GetMapping("/cliente/{id}")
    public Cliente getCliente(@PathVariable("id") int id) {
        return null;
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") int id) {
      return ResponseEntity.noContent().build();
    }
    
}
