package com.calabreso.restaurante;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import com.calabreso.restaurante.entity.*;
import com.calabreso.restaurante.entity.Cliente;
import com.calabreso.restaurante.entity.Restaurante;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestauranteApplication {
    static Scanner teclado;
    static Restaurante restaurante;

    static Cardapio cardapio;

    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausa() {
        System.out.println("Tecle Enter para continuar.");
        teclado.nextLine();
    }

    static void cabecalho() {
        limparTela();
        System.out.println(" LPM VEGAN - v1.0 ");
        System.out.println("=====================");
    }

    static void registrarRequisicao(Requisicao requisicao) {
        restaurante.registrarRequisicao(requisicao);
    }

    static void atenderRequisicao() {
        cabecalho();
        int idCli;
        System.out.print("Digite o id do cliente: ");
        idCli = Integer.parseInt(teclado.nextLine());
        Cliente localizado = restaurante.localizarCliente(idCli);
        if (localizado == null) {
            System.out.println("Cliente não localizado. Vamos cadastrá-lo:");
            localizado = cadastrarNovoCliente();
            restaurante.addCliente(localizado);
        }
        Optional<Requisicao> requisicao = criarRequisicao(localizado);
        requisicao.ifPresent(RestauranteApplication::registrarRequisicao);
    }

    static int MenuPrincipal() {
        int opcao;
        cabecalho();    
        System.out.println("1 - Verificar Mesas");
        System.out.println("2 - Verificar Fila");
        System.out.println("3 - Cadastrar nova requisição");
        System.out.println("4 - Encerrar Mesa");
        System.out.println("5 - Exibir Cardápio");
        System.out.println("6 - Fazer Pedido");
        System.out.println("7 - Fechar Conta");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        opcao = Integer.parseInt(teclado.nextLine());
        return opcao;
    }

    static void filaDeEspera(){
        cabecalho();
        System.out.println(restaurante.mostrarFila());
        pausa();
    }

    static void exibirMesas() {
        cabecalho();
        System.out.println(restaurante.statusMesas());
        pausa();
    }

    static Cliente cadastrarNovoCliente() {
        String nome;
        System.out.print("Nome do cliente: ");
        nome = teclado.nextLine();
        Cliente novo = new Cliente(1, nome);
        System.out.println("Cliente cadastrado: " + novo);
        pausa();
        return novo;
    }

    static Optional<Requisicao> criarRequisicao(Cliente cliente) {
        int quantasPessoas;
        cabecalho();
        System.out.print("Para quantas pessoas será a mesa? ");
        quantasPessoas = Integer.parseInt(teclado.nextLine());
        Requisicao novaRequisicao = new Requisicao(quantasPessoas, cliente);
        restaurante.registrarRequisicao(novaRequisicao);
        novaRequisicao = restaurante.processarFila();
        if(novaRequisicao!=null){
            System.out.println(novaRequisicao);
        } else {
            System.out.println("Não há mesas disponíveis no momento. Requisição em espera");
        }
        pausa();
        return Optional.of(novaRequisicao);
    }


    static String escolherFormatoCardapio() {
        return "Deseja exibir o cardápio completo, ou apenas bebidas ou comidas?\n1- Cardápío completo\n2 - Bebidas\n3 - Comidas";
    }

    static void encerrarMesa() {
        int idMesa;
        cabecalho();
        System.out.print("Qual o número da mesa para encerrar atendimento? ");
        idMesa = Integer.parseInt(teclado.nextLine());
        Requisicao finalizada = restaurante.encerrarAtendimento(idMesa);
        if (finalizada != null) {
            if (Objects.equals(finalizada.toString(), " Em espera.")) {
                System.out.println("Atendimento da mesa " + idMesa + " encerrado com sucesso!");
            } else {
                System.out.println(finalizada);
            }
        } else {
            System.out.println("Mesa " + idMesa + " não está em atendimento");
        }
        pausa();
    }

    static void exibirCardapio() {
        System.out.println(escolherFormatoCardapio());
        String opcao = teclado.nextLine();
        System.out.println(cardapio.exibirCardapio(opcao));
        pausa();
    }

    static void fazerPedido() {
        System.out.println("Qual o ID da sua mesa?");
        int idMesa =  Integer.parseInt(teclado.nextLine());
         if (restaurante.mesaLiberada(idMesa)) {
             Pedido pedido = new Pedido();
             pedido.setIdMesa(idMesa);

             ArrayList<OpcaoCardapio> itensDoPedido = new ArrayList<OpcaoCardapio>();
             System.out.println(cardapio.exibirCardapio(
                     "1"));
             int opcaoMenu;
             do {
                 System.out.println("Qual o ID do item que você deseja pedir?");
                 int idOpcao =  Integer.parseInt(teclado.nextLine());
                 OpcaoCardapio opcao = cardapio.getOpcaoById(idOpcao);
                 itensDoPedido.add(opcao);
//          adicionar opcao ao pedido da mesa
                 System.out.println(opcao.getNome() + " adicionado com sucesso ao seu pedido!");

                 System.out.println("Deseja adicionar outro item ao seu pedido?");
                 System.out.println("1- SIM");
                 System.out.println("2- NAO");
                 opcaoMenu =  Integer.parseInt(teclado.nextLine());
             } while (opcaoMenu == 1);

             pedido.setItens(itensDoPedido);
             restaurante.pedidos.add(pedido);
             System.out.println("Pronto, seu pedido será preparado!");
             System.out.println("Já gostaria de encerrar sua conta?");
             System.out.println("1- SIM");
             System.out.println("2- NAO");
             int encerrarConta = Integer.parseInt(teclado.nextLine());
             if (encerrarConta == 1) {
                 fecharConta(Optional.of(idMesa));
             }
             pausa();
         } else {
             throw new IllegalArgumentException("Mesa sem cliente alocado");
         }

    }

    static void fecharConta(Optional<Integer> idMesaParam) {
        int idMesa = 0;
        if (idMesaParam.isPresent()) {
            idMesa = idMesaParam.get();
        } else {
            System.out.println("Qual o ID da sua mesa?");
            idMesa = Integer.parseInt(teclado.nextLine());
        }
        if (restaurante.getMesaById(idMesa).estahLiberada(100)) {
            throw new IllegalArgumentException("Mesa sem cliente alocado");
        }

        System.out.println("Quantas pessoas dividirão a conta?");
        int qtdPessoas =  Integer.parseInt(teclado.nextLine());

//        pegar pedido da mesa
        OpcaoCardapio itensPedido = restaurante.pedidos.filter(pedido -> pedido.getIdMesa() == idMesa).get().getItens();

        System.out.println("=== PEDIDO PARA A MESA " + idMesa);
        for (OpcaoCardapio item : itensPedido) {
            System.out.println("- " + item.getNome() + "  R$" + item.getPreco());
        }

        System.out.println(pedido.fecharPedido(qtdPessoas));
    }

    public static void main(String[] args) throws Exception {
        try {
            teclado = new Scanner(System.in);
            int opcao;
            restaurante = new Restaurante();
            cardapio =  new Cardapio();
            do {
                opcao = MenuPrincipal();
                switch (opcao) {
                    case 1 -> exibirMesas();
                    case 2 -> filaDeEspera();
                    case 3 -> atenderRequisicao();
                    case 4 -> encerrarMesa();
                    case 5 -> exibirCardapio();
                    case 6 -> fazerPedido();
                    case 7 -> fecharConta(Optional.of(null));
                }
            } while (opcao != 0);
            teclado.close();
        } catch (NumberFormatException e) { // caso o usuário pressione Enter sem digitar nenhum número
            System.out.println("Opção inválida");
        }

    }
}
