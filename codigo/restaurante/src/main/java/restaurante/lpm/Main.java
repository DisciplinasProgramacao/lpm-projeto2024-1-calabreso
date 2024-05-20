package restaurante.lpm;

import restaurante.lpm.cardapio.Cardapio;
import restaurante.lpm.mesa.Mesa;
import restaurante.lpm.restaurante.Restaurante;

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
    }
}
