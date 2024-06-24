package com.calabreso.restaurante.controller;

import com.calabreso.restaurante.entity.Cliente;
import com.calabreso.restaurante.entity.OpcaoCardapio;
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
    public @ResponseBody Requisicao novaRequisicao(@PathVariable Integer quantPessoas, @PathVariable Cliente cliente) {
        // Implementação do método aqui
        // Exemplo: criar e retornar uma nova requisição
        Requisicao requisicao = new Requisicao(quantPessoas, cliente);
        return requisicao;
    }

    @GetMapping("/requisicoes/{id}")
    public @ResponseBody Requisicao buscarRequisicao(@PathVariable Integer id) {
        // Implementação do método aqui
        // Exemplo: buscar e retornar uma requisição pelo id
        Requisicao requisicao = new Requisicao(1, new Cliente()); // substitua pelo método de busca real
        return requisicao;
    }

    @PutMapping("/requisicoes/pedir/{id}/{produto}")
    public @ResponseBody Requisicao addProduto(@PathVariable Integer id, @PathVariable OpcaoCardapio produto) {
        // Implementação do método aqui
        // Exemplo: adicionar um produto a uma requisição e retornar a requisição atualizada
        Requisicao requisicao = new Requisicao(1, new Cliente()); // substitua pelo método de busca real
        requisicao.addProduto(produto);
        return requisicao;
    }

    @PutMapping("/requisicoes/alocar/{idReq}/{idMesa}")
    public @ResponseBody Requisicao alocarMesa(@PathVariable Integer idMesa, @PathVariable Integer idReq) {
        // Implementação do método aqui
        // Exemplo: alocar uma mesa a uma requisição e retornar a requisição atualizada
        Requisicao requisicao = new Requisicao(1, new Cliente()); // substitua pelo método de busca real
        Mesa mesa = new Mesa(idMesa); // substitua pelo método de busca real
        requisicao.alocarMesa(mesa);
        return requisicao;
    }

    @PutMapping("/requisicoes/encerrar/{id}")
    public @ResponseBody Requisicao encerrarRequisicao(@PathVariable Integer id) {
        // Implementação do método aqui
        // Exemplo: encerrar uma requisição e retornar a requisição atualizada
        Requisicao requisicao = new Requisicao(1, new Cliente()); // substitua pelo método de busca real
        requisicao.encerrar();
        return requisicao;
    }
}
