package fronteira;


import java.util.List;
import java.util.Scanner;

import controller.AvaliacaoController;
import controller.AvaliadorController;
import controller.ClienteController;
import model.Avaliacao;
import model.Avaliador;
import model.Cliente;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        // Inicialização do controlador de Cliente
        ClienteController c = new ClienteController();
        AvaliadorController ava = new AvaliadorController();
        AvaliacaoController av = new AvaliacaoController();
        

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Pesquisar um Cliente");
            System.out.println("3. Pesquisar Todos");
            System.out.println("4. Apagar um Cliente");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Criando e persistindo um cliente
                    Cliente cliente1 = new Cliente(1,"000000000000", "Beatriz", "Teste 1", "1", "Bea", "Beatri", "Beat",
                            "construcao", "tutu", "testeExemplo@teste.com");
                    c.inserirCliente(cliente1);

                    // Criando e persistindo um avaliador
                    Avaliador avaliador1 = new Avaliador(1,"Jorge", "Jorge@genio", "25789");
                    ava.inserirAvaliador(avaliador1);
                    
                    // Criando e persistindo uma avaliação
                    Avaliacao avaliacao1 = new Avaliacao(1L, null, "otimo", 1, "bom", cliente1);
                    av.inserirAvaliacao(avaliacao1);

                    System.out.println("Cliente, Avaliador e Avaliação inseridos com sucesso.");
                    break;

                case 2:
                    System.out.println("Pesquisar um Cliente = ");
                    String nomeEmpresa = scanner.next();
                    List<Cliente> clientes = c.pesquisarUmCliente(nomeEmpresa);
                    if (!clientes.isEmpty()) {
                        for (Cliente cliente : clientes) {
                            System.out.println("\nId= " + cliente.getIdCliente() + "\nCNPJ: " + cliente.getCnpj()
                                    + "\nNome da empresa: " + cliente.getNomeEmpresa() + "\nResponsavel: "
                                    + cliente.getNomeCliente() + "\nEmail: " + cliente.getEmailCliente());
                        }
                    } else {
                        System.out.println("Não encontrou o Cliente");
                    }
                    break;

                case 3:
                    System.out.println("Listando Todos os Clientes");
                    List<Cliente> todosClientes = c.pesquisarTodos();
                    if (!todosClientes.isEmpty()) {
                        for (Cliente cliente : todosClientes) {
                            System.out.println("\nId= " + cliente.getIdCliente() + "\nCNPJ: " + cliente.getCnpj()
                                    + "\nNome da empresa: " + cliente.getNomeEmpresa() + "\nResponsavel: "
                                    + cliente.getNomeCliente() + "Email: " + cliente.getEmailCliente());
                        }
                    } else {
                        System.out.println("Não encontrou o Cliente");
                    }
                    break;

                case 4:
                    System.out.println("Escolha um Cliente para Apagar ");
                    long id = scanner.nextLong();
                    c.apagar(id);
                    break;

                case 5:
                    System.out.println("Saindo do menu.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
        } while (escolha != 5);

        scanner.close();
    }
}