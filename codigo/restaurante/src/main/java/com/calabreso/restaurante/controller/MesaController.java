package com.calabreso.restaurante.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calabreso.restaurante.entity.Cliente;
import com.calabreso.restaurante.entity.Mesa;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/mesas")
public class MesaController<MesaService> {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @PostMapping
    public Mesa criarMesa(@RequestBody Mesa mesa) {
        return ((Object) mesaService).criarMesa(mesa);
    }

    @GetMapping
    public List<Mesa> obterTodasMesas() {
        return ((Object) mesaService).obterTodasMesas();
    }

    @GetMapping("/{id}")
    public Mesa obterMesaPorId(@PathVariable int id) {
        return ((Object) mesaService).obterMesaPorId(id);
    }

    @PutMapping("/{id}")
    public Mesa atualizarMesa(@PathVariable int id, @RequestBody Mesa mesa) {
        return ((Object) mesaService).atualizarMesa(id, mesa);
    }

    @DeleteMapping("/{id}")
    public void removerMesa(@PathVariable int id) {
        ((Object) mesaService).removerMesa(id);
    }
}
public void
