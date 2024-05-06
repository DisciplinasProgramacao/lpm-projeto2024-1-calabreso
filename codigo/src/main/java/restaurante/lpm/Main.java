package main.java.restaurante.lpm;

import main.java.restaurante.lpm.business.*;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1, "João"); 
        cliente1.fazerPedido("Pizza de pepperoni");
        cliente1.declararQuantidade(5);

        Cliente cliente2 = new Cliente(2, "Pedro"); 
        cliente2.fazerPedido("Pizza de calabresa");
        cliente2.declararQuantidade(3);
    }
}

