package restaurante.lpm.pedido;

import restaurante.lpm.opcaoCardapio.OpcaoCardapio;
import restaurante.lpm.cardapio.Cardapio;

import java.util.ArrayList;

public class Pedido {

    private int idMesa;
    private ArrayList<OpcaoCardapio> itens;
    private double valorTotal;
    private final double TAXA = 0.1;

    // Adicionando uma referência ao cardápio
    private Cardapio cardapio;

    public Pedido(Cardapio cardapio) {
        this.cardapio = cardapio;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public ArrayList<OpcaoCardapio> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getTAXA() {
        return TAXA;
    }

    // Função para ver o menu
    public void verMenu() {
        cardapio.mostrarCardapio();
    }

    // Função para selecionar um produto do menu
    public OpcaoCardapio selecionarProduto(int codigo) {
        return cardapio.buscarOpcao(codigo);
    }

    // Função para incluir um produto ao pedido
    public void incluirProduto(OpcaoCardapio item) {
        itens.add(item);
        valorTotal += item.getPreco();
    }

    // Função para fechar a conta
    public double fecharConta() {
        double totalComTaxa = valorTotal * (1 + TAXA);
        valorTotal = 0.0; // Resetando o valor total após fechar a conta
        return totalComTaxa;
    }

    // Função para mostrar a conta
    public void mostrarConta() {
        System.out.println("----- Conta da Mesa " + idMesa + " -----");
        for (OpcaoCardapio item : itens) {
            System.out.println(item.getNome() + " - R$ " + item.getPreco());
        }
        System.out.println("Taxa: " + (TAXA * 100) + "%");
        System.out.println("Total: R$ " + fecharConta());
    }
}
