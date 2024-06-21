package com.calabreso.restaurante.entity;

import java.util.ArrayList;

/**
 * Classe que representa um pedido fechado no restaurante.
 * Herda a funcionalidade básica da classe Pedido e adiciona validações e cálculos específicos.
 */
public class PedidoFechado extends Pedido {

    /**
     * Construtor da classe PedidoFechado.
     */
    public PedidoFechado(int idMesa, ArrayList<OpcaoCardapio> itens) throws IllegalArgumentException {
        super(); // Chamando o construtor da classe pai
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("O pedido deve conter pelo menos um item.");
        }
        this.setIdMesa(idMesa);
        this.setItens(itens);
        this.calcularValorTotal();
    }

    /**
     * Define a lista de itens do pedido após validar se a lista não é nula ou vazia.
     */
    @Override
    public void setItens(ArrayList<OpcaoCardapio> itens) throws IllegalArgumentException {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("O pedido deve conter pelo menos um item.");
        }
        super.setItens(itens);
        this.calcularValorTotal();
    }

    /**
     * Calcula o valor total do pedido, incluindo a taxa.
     */
    private void calcularValorTotal() {
        double valorTotalItens = 0.0;
        for (OpcaoCardapio item : this.getItens()) {
            valorTotalItens += item.getPreco();
        }
        super.setValorTotal(valorTotalItens + (valorTotalItens * this.getTAXA()));
    }

    /**
     * Fecha o pedido e calcula o valor por pessoa, se o número de pessoas for válido.
     */
    @Override
    public String fecharPedido(int qtdPessoasDividirConta) throws IllegalArgumentException {
        if (qtdPessoasDividirConta <= 0) {
            throw new IllegalArgumentException("A quantidade de pessoas para dividir a conta deve ser maior que zero.");
        }
        double valorPorPessoa = this.getValorTotal() / qtdPessoasDividirConta;
        return "Valor total do pedido: " + "\t" + this.getValorTotal() + "\n" +
                "Valor por pessoa: " + "\t" + valorPorPessoa + "\n" +
                "Agradecemos a preferência!";
    }

    /**
     * Retorna o valor total do pedido.
     */
    @Override
    public double getValorTotal() {
        return super.getValorTotal();
    }
}
