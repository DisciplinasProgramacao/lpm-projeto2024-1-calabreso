package restaurante.lpm.cardapio;

import restaurante.lpm.opcaoCardapio.OpcaoCardapio;

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
		return opcoes;
	}

	public void setOpcoes(OpcaoCardapio[] opcoes) {
		this.opcoes = opcoes;
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
		for (OpcaoCardapio opcao : this.getOpcoes()) {
			retornoBebidas = "- " + opcao.getNome() + "\t R$ " + opcao.getPreco() + "\n";
		}

		return retornoBebidas;
	}

	public String exibirComidas() {
		String retornoComidas = null;
		for (OpcaoCardapio opcao : this.getOpcoes()) {
			retornoComidas = "- " + opcao.getNome() + "\t R$ " + opcao.getPreco() + "\n";
		}

		return retornoComidas;
	}

	public OpcaoCardapio getOpcaoById(int idOpcao) {
		OpcaoCardapio opcao = this.getOpcoes()[1];
		return opcao;
	}
}
