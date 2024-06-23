package com.calabreso.restaurante.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calabreso.restaurante.entity.Mesa;
import com.calabreso.restaurante.entity.Requisicao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping(value = "/requisicao")
@RestController
public class RequisicaoController {

    @PostMapping("/requisicoes/{idCliente}/{quantPessoas}")
public @ResponseBody Requisicao novaRequisicao(@PathVariable Integer quantPessoas, @PathVariable Integer idCliente)

@GetMapping("/requisicoes/{id}")
public @ResponseBody Requisicao buscarRequisicao(@PathVariable Integer id) {

@PutMapping("/requisicoes/pedir/{id}/{produto}")
public @ResponseBody Requisicao addProduto(@PathVariable Integer id, @PathVariable Integer produto)

@PutMapping("/requisicoes/alocar/{idReq}/{idMesa}")
public @ResponseBody Requisicao alocarMesa(@PathVariable Integer idMesa, @PathVariable Integer idReq)

@PutMapping("/requisicoes/encerrar/{id}")
public @ResponseBody Requisicao encerrarRequisicao(@PathVariable Integer id)
    
   
}
