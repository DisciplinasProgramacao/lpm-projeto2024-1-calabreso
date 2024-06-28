package com.calabreso.restaurante.entity;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Cardapio {

	private OpcaoCardapio[] opcoes;

	public Cardapio() {
		this.opcoes = new OpcaoCardapio[]{
			// Bebidas
				new OpcaoCardapio("Água", 3, 1, "bebida"),
				new OpcaoCardapio("Copo de suco", 7, 2, "bebida"),
				new OpcaoCardapio("Refrigerante orgânico", 7, 3, "bebida"),
				new OpcaoCardapio("Cerveja vegana", 9, 4, "bebida"),
				new OpcaoCardapio("Taça de vinho vegano", 18, 5, "bebida"),
			// Comidas
				new OpcaoCardapio("Moqueca de palmito", 32, 6, "comida"),
				new OpcaoCardapio("Falafel assado", 20, 7, "comida"),
				new OpcaoCardapio("Salada primavera com macarrão Konjac", 25, 8, "comida"),
				new OpcaoCardapio("Escondidinho de inhame", 18, 9, "comida"),
				new OpcaoCardapio("Strogonoff de cogumelos", 35, 10, "comida"),
				new OpcaoCardapio("Caçarola de legumes", 22, 11, "comida")
		};
	}

	public OpcaoCardapio[] getOpcoes() {
		return this.opcoes;
	}

	public void setOpcoes(OpcaoCardapio[] opcoes) {
		this.opcoes = opcoes;
	}

	public void addOpcao(OpcaoCardapio novaOpcao) {
		if (this.opcoes == null) {
			this.opcoes = new OpcaoCardapio[]{novaOpcao};
		} else {
			OpcaoCardapio[] novaLista = new OpcaoCardapio[this.opcoes.length + 1];
			System.arraycopy(this.opcoes, 0, novaLista, 0, this.opcoes.length);
			novaLista[this.opcoes.length] = novaOpcao;
			this.opcoes = novaLista;
		}
	}


	public String exibirCardapio(String opcao) {
        return switch (opcao) {
			case "1" -> this.exibirBebidas() + "\n" + this.exibirComidas();
			case "2" -> this.exibirBebidas();
			case "3" -> this.exibirComidas();
			default -> "Opção inválida";
		};
	}

	public String exibirBebidas() {
		String retornoBebidas = "";
		for (OpcaoCardapio opcao : this.getOpcoes()) {
			if (Objects.equals(opcao.getTipo(), "bebida")) {
				retornoBebidas += opcao.getId() + "- " + opcao.getNome() + "\t R$ " + opcao.getPreco() + "\n";
//				System.out.println(retornoBebidas);
			}
		}

		return retornoBebidas;
	}

	public String exibirComidas() {
		String retornoComidas = "";
		for (OpcaoCardapio opcao : this.getOpcoes()) {
			if (Objects.equals(opcao.getTipo(), "comida")) {
				retornoComidas += opcao.getId() + "- " + opcao.getNome() + "\t R$ " + opcao.getPreco() + "\n";
//				System.out.println(retornoComidas);
			}
		}

		return retornoComidas;
	}

	public OpcaoCardapio getOpcaoById(int idOpcao) {
        return Arrays.stream(this.getOpcoes()).filter(opcaoCardapio -> opcaoCardapio.getId() == idOpcao).findFirst().get();
	}
}
