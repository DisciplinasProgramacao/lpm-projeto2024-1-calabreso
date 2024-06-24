package com.calabreso.restaurante.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

import com.calabreso.restaurante.entity.Cliente;
//import com.calabreso.restaurante.Service.ClienteService;
//
//import javax.validation.Valid;

@RestController
@RequestMapping(value = "/clientes")
@Validated
public class ClienteController {

//    @Autowired
//    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
//        List<Cliente> list = clienteService.findAll();
        List<Cliente> list = new List<Cliente>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Cliente> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Cliente cliente) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Cliente> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Cliente> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Cliente get(int index) {
                return null;
            }

            @Override
            public Cliente set(int index, Cliente element) {
                return null;
            }

            @Override
            public void add(int index, Cliente element) {

            }

            @Override
            public Cliente remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Cliente> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Cliente> listIterator(int index) {
                return null;
            }

            @Override
            public List<Cliente> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
//        Cliente obj = clienteService.findById(id);
        Cliente obj = new Cliente();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(Cliente.CreateCliente.class)
    public ResponseEntity<Cliente> create(@RequestBody Cliente obj) {
//        obj = clienteService.create(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getClienteId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente obj) {
//        Cliente entity = clienteService.update(id, obj);
        Cliente entity = new Cliente();
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
//        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
//        clienteService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
