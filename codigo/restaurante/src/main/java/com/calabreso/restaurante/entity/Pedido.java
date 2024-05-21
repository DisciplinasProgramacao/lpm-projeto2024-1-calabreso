package com.calabreso.restaurante.entity;

import java.util.ArrayList;

public class Pedido {

	private int idMesa;

	private ArrayList<OpcaoCardapio> itens;

	private double valorTotal;

	private final double TAXA = 0.1;

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public ArrayList<OpcaoCardapio> getItens() {
		return itens;
	}

	public void setItens(ArrayList<OpcaoCardapio> itens) {
		this.itens = itens;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valoTotal) {
		this.valorTotal = valoTotal;
	}

	public double getTAXA() {
		return TAXA;
	}

	public String fecharPedido(int qtdPessoasDividirConta) {
		double valorTotalItens = 0.0;
		for (OpcaoCardapio item : this.getItens()) {
			valorTotalItens += item.getPreco();
		}

		this.setValorTotal(valorTotalItens + (valorTotalItens*this.getTAXA()));
		return "Valor total do pedido: " + "\t" + this.getValorTotal() + "\n" +
				"Valor por pessoa: " + "\t" + this.getValorTotal() / qtdPessoasDividirConta + "\n" +
				"Agradecemos a preferência!";
	}

}
