package fronteira;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controller.AvaliacaoController;
import controller.FormularioController;
import controller.ClienteController;
import model.Avaliacao;
import model.Formulario;
import model.Cliente;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int escolha;

		// Inicialização controle
		ClienteController c = new ClienteController();
		FormularioController fo = new FormularioController();
		AvaliacaoController av = new AvaliacaoController();

		// teste de calculo exemplo para gerar pontuacao do formulario
		int[] vetRespostasForms1 = { 1, 3, 5, 2, 4, 2, 1, 5, 2, 3, 4, 4, 5, 5, 3, 2, 5, 3 };
		int[] vetRespostasForms2 = { 4, 5, 3, 1, 2, 5, 1, 1, 2, 4, 5, 3, 2, 2, 1, 3, 1, 5 };
		int[] vetRespostasForms3 = { 5, 5, 5, 5, 4, 5, 5, 5, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5 };

		// Menu de Testes
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
				// Criando e persistindo clientes
				Cliente cliente1 = new Cliente(1, "000000000000", "Beatriz", "Teste 1", "1", "Bea", "Beatri", "Beat",
						"construcao", "tutu", "testeExemplo@teste.com");
				Cliente cliente2 = new Cliente(2, "000000000001", "Jorge", "Teste 2", "2", "Jor", "Jorg", "Teste",
						"construcao", "Atta", "testExemplo@test.com");
				c.inserirCliente(cliente1);
				c.inserirCliente(cliente2);

				// Criando e persistindo formularios
				Formulario formulario1 = new Formulario(1L, false, vetRespostasForms1, cliente1);
				Formulario formulario2 = new Formulario(2L, true, vetRespostasForms2, cliente2);
				Formulario formulario3 = new Formulario(3L, true, vetRespostasForms3, cliente2);
				fo.inserirFormulario(formulario1);
				fo.inserirFormulario(formulario2);
				fo.inserirFormulario(formulario3);

				// Criando e persistindo avaliações
				Avaliacao avaliacao1 = new Avaliacao(1L, LocalDateTime.parse("2024/02/26 23:41",DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")), av.gerarDiagnostico(formulario1), av.gerarPontuacao(formulario1),
						av.gerarNivelAderencia(formulario1), cliente1, formulario1);
				Avaliacao avaliacao2 = new Avaliacao(2L, LocalDateTime.parse("2024/02/11 23:41",DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")),av.gerarDiagnostico(formulario2), av.gerarPontuacao(formulario2),
						av.gerarNivelAderencia(formulario2), cliente2, formulario2);
				Avaliacao avaliacao3 = new Avaliacao(3L, LocalDateTime.parse("2024/03/30 23:41",DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")), av.gerarDiagnostico(formulario3), av.gerarPontuacao(formulario3),
						av.gerarNivelAderencia(formulario3), cliente1, formulario3);
				av.inserirAvaliacao(avaliacao1);
				av.inserirAvaliacao(avaliacao2);
				av.inserirAvaliacao(avaliacao3);

				System.out.println("\nCliente, Formulario e Avaliação inseridos com sucesso.");
				break;

			case 2:
				// pesquisa cliente pelo nome da empresa
				System.out.println("Pesquisar uma Empresa = ");
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
				// lista todos os clientes
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
				// apaga clientes do banco
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