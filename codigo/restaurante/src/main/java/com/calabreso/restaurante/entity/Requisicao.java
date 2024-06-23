package com.calabreso.restaurante.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma requisição (pedido) de um cliente no restaurante.
 */
public class Requisicao {

    private Cliente cliente;
    private Mesa mesa;
    private int quantPessoas;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private boolean encerrada;
    private List<OpcaoCardapio> produtos;
    private int id;

    /**
     * Constrói uma nova Requisicao com a quantidade de pessoas e o cliente especificado.
     *
     * @param quantPessoas a quantidade de pessoas para esta requisição
     * @param cliente o cliente que fez a requisição
     */
    public Requisicao(int quantPessoas, Cliente cliente) {
        this.quantPessoas = quantPessoas > 1 ? quantPessoas : 1;
        this.cliente = cliente;
        this.entrada = null;
        this.saida = null;
        this.mesa = null;
        this.encerrada = false;
        this.produtos = new ArrayList<>();
        this.id = (int) (Math.random() * 10000); // Geração simples de ID para exemplo
    }

    /**
     * Encerra a requisição e libera a mesa.
     *
     * @return a mesa que foi liberada
     * @throws IllegalStateException se a requisição já estiver encerrada
     */
    public Mesa encerrar() {
        if (encerrada) {
            throw new IllegalStateException("A requisição já está encerrada.");
        }
        saida = LocalDateTime.now();
        mesa.desocupar();
        encerrada = true;
        return mesa;
    }

    /**
     * Aloca uma mesa para esta requisição se estiver disponível.
     *
     * @param mesa a mesa a ser alocada
     * @throws IllegalStateException se a requisição já estiver encerrada
     * @throws IllegalArgumentException se a mesa não estiver disponível para a quantidade de pessoas
     */
    public void alocarMesa(Mesa mesa) {
        if (encerrada) {
            throw new IllegalStateException("Não é possível alocar uma mesa para uma requisição encerrada.");
        }
        if (mesa.estahLiberada(quantPessoas)) {
            this.mesa = mesa;
            entrada = LocalDateTime.now();
            this.mesa.ocupar();
        } else {
            throw new IllegalArgumentException("A mesa não está liberada para a quantidade de pessoas.");
        }
    }

    /**
     * Verifica se a requisição está encerrada.
     *
     * @return true se a requisição está encerrada, false caso contrário
     */
    public boolean estahEncerrada() {
        return encerrada;
    }

    /**
     * Verifica se esta requisição está associada à mesa especificada.
     *
     * @param idMesa o ID da mesa a ser verificada
     * @return true se a requisição está associada à mesa, false caso contrário
     */
    public boolean ehDaMesa(int idMesa) {
        return mesa != null && idMesa == mesa.getIdMesa();
    }

    /**
     * Retorna a quantidade de pessoas para esta requisição.
     *
     * @return a quantidade de pessoas
     */
    public int quantPessoas() {
        return quantPessoas;
    }

    /**
     * Adiciona um produto (opção de cardápio) a esta requisição.
     *
     * @param opcao o produto a ser adicionado
     * @throws IllegalStateException se a requisição já estiver encerrada
     */
    public void addProduto(OpcaoCardapio opcao) {
        if (encerrada) {
            throw new IllegalStateException("Não é possível adicionar produtos a uma requisição encerrada.");
        }
        produtos.add(opcao);
    }

    /**
     * Calcula o custo total de todos os produtos nesta requisição.
     *
     * @return o custo total
     */
    public double calcularTotal() {
        double total = 0.0;
        for (OpcaoCardapio opcao : produtos) {
            total += opcao.getPreco();
        }
        return total;
    }

    /**
     * Retorna o ID desta requisição.
     *
     * @return o ID da requisição
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder stringReq = new StringBuilder(cliente.toString());
        if (mesa != null) {
            stringReq.append("\n").append(mesa.toString()).append("\n");
            stringReq.append("Entrada em ").append(formato.format(entrada)).append("\n");
            if (saida != null) {
                stringReq.append("Saída em ").append(formato.format(saida)).append("\n");
            }
        } else {
            stringReq.append(" Em espera.");
        }
        return stringReq.toString();
    }
}
