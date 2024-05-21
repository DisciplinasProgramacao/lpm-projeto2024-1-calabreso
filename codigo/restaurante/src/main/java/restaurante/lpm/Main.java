package restaurante.lpm;

import restaurante.lpm.cardapio.Cardapio;
import restaurante.lpm.mesa.Mesa;
import restaurante.lpm.opcaoCardapio.OpcaoCardapio;
import restaurante.lpm.pedido.Pedido;
import restaurante.lpm.restaurante.Restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Mesa[] mesas = new Mesa[]{
                new Mesa(1, 4, true),
                new Mesa(2, 4, true)
        };

        Restaurante restaurante = new Restaurante();
        restaurante.setMesas(mesas);

        Cardapio cardapio = new Cardapio();

        System.out.println(cardapio.escolherFormatoCardapio());

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        System.out.println(cardapio.exibirCardapio(opcao));

        ArrayList<OpcaoCardapio> opcoesEscolhidas = new ArrayList<>();
        opcoesEscolhidas.add(cardapio.getOpcaoById(1));
        opcoesEscolhidas.add(cardapio.getOpcaoById(4));


        Pedido pedido = new Pedido();
        pedido.setIdMesa(1);
        pedido.setItens(opcoesEscolhidas);
        System.out.println(pedido.fecharPedido(2));
    }
}
