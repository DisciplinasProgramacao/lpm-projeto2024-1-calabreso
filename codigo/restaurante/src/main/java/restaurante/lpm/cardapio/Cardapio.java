package restaurante.lpm.cardapio;

import restaurante.lpm.opcaoCardapio.OpcaoCardapio;

import java.util.Scanner;

public class Cardapio {

	private OpcaoCardapio[] bebidas;
	private OpcaoCardapio[] comidas;

	public Cardapio() {
		this.bebidas = new OpcaoCardapio[]{
				new OpcaoCardapio("Água", 3, 1),
				new OpcaoCardapio("Copo de suco", 7, 2),
				new OpcaoCardapio("Refrigerante orgânico", 7, 3),
				new OpcaoCardapio("Cerveja vegana", 9, 4),
				new OpcaoCardapio("Taça de vinho vegano", 18, 5)
		};
		this.comidas = new OpcaoCardapio[]{
				new OpcaoCardapio("Moqueca de palmito", 32, 1),
				new OpcaoCardapio("Falafel assado", 20, 2),
				new OpcaoCardapio("Salada primavera com macarrão Konjac", 25, 3),
				new OpcaoCardapio("Escondidinho de inhame", 18, 4),
				new OpcaoCardapio("Strogonoff de cogumelos", 35, 5),
				new OpcaoCardapio("Caçarola de legumes", 22, 6)
		};
	}

	public OpcaoCardapio[] getBebidas() {
		return bebidas;
	}

	public void setBebidas(OpcaoCardapio[] bebidas) {
		this.bebidas = bebidas;
	}

	public OpcaoCardapio[] getComidas() {
		return comidas;
	}

	public void setComidas(OpcaoCardapio[] comidas) {
		this.comidas = comidas;
	}

	public String escolherFormatoCardapio() {
		return "Deseja exibir o cardápio completo, ou apenas bebidas ou comidas?\n1- Cardápío completo\n2 - Bebidas\n3 - Comidas";
	}

	public String exibirCardapio(String opcao) {
		String retornoCardapio;
		switch (opcao) {
			case "1":
				retornoCardapio = this.exibirBebidas() + "\n" + this.exibirComidas();
				break;
			case "2":
				retornoCardapio = this.exibirBebidas();
				break;
			case "3":
				retornoCardapio = this.exibirComidas();
				break;
			default:
				retornoCardapio = "Opção inválida";
				break;
		}
		return retornoCardapio;
	}

	public String exibirBebidas() {
		String retornoBebidas = null;
		for (OpcaoCardapio bebida : this.getBebidas()) {
			retornoBebidas = "- " + bebida.getNome() + "\t R$ " + bebida.getPreco() + "\n";
		}

		return retornoBebidas;
	}

	public String exibirComidas() {
		String retornoComidas = null;
		for (OpcaoCardapio comida : this.getComidas()) {
			retornoComidas = "- " + comida.getNome() + "\t R$ " + comida.getPreco() + "\n";
		}

		return retornoComidas;
	}
}
