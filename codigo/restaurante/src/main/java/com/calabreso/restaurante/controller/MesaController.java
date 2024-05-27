package com.calabreso.restaurante.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calabreso.restaurante.entity.Cliente;
import com.calabreso.restaurante.entity.Mesa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @PostMapping
    public Mesa criarMesa(@RequestBody Mesa mesa) {
        return mesaService.criarMesa(mesa);
    }

    @GetMapping
    public List<Mesa> obterTodasMesas() {
        return mesaService.obterTodasMesas();
    }

    @GetMapping("/{id}")
    public Mesa obterMesaPorId(@PathVariable int id) {
        return mesaService.obterMesaPorId(id);
    }

    @PutMapping("/{id}")
    public Mesa atualizarMesa(@PathVariable int id, @RequestBody Mesa mesa) {
        return mesaService.atualizarMesa(id, mesa);
    }

    @DeleteMapping("/{id}")
    public void removerMesa(@PathVariable int id) {
        mesaService.removerMesa(id);
    }
}
