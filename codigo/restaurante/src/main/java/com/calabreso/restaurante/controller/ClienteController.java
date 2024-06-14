package com.calabreso.restaurante.controller;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/clientes")
@Validated
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> list = clienteService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente obj = this.clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(Cliente.CreateCliente.class)
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente obj) {
       obj = clienteService.create(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getClienteId())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(obj);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @Valid @RequestBody Cliente obj) {
        Cliente entity = clienteService.update(id, obj);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        clienteService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
