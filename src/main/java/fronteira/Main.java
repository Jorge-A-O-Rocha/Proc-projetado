package fronteira;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import controller.ClienteController;
import controller.JPAUtil;
import model.Avaliacao;
import model.Avaliador;
import model.Cliente;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nomeEmpresa;
		Cliente c1 = new Cliente();
		Avaliador av = new Avaliador();
		Avaliacao ava = new Avaliacao();
		ClienteController cControl = new ClienteController();
		int escolha;

		// Vetores de testes cliente
		String[] vetCnpjCliente = { "000000000000", "000000000001", "000000000002", "000000000003" };
		String[] vetNomeCliente = { "Fulano 1", "Fulano 2", "Fulano 3", "Fulano 4" };
		String[] vetIdContrato = { "1", "2", "3", "4" };
		String[] vetNomeEmpresa = { "Teste 1", "Teste 2", "Teste 3", "Teste 4" };
		String[] vetEmailCliente = { "testeExemplo@teste.com", "testExe@teste.com", "tesExem@teste.com",
				"Exemplo@teste.com" };
		String[] vetRazaoSocial = { "Ful 1", "Ful 2", "Ful 3", "Ful 4" };
		String[] vetNomeGestor = { "Sicrano 1", "Sicrano 2", "Sicrano 3", "Sicrano 4" };
		String[] vetPontoFocal = { "Test", "Teste", "Testando", "Testado" };
		String[] vetTipoServico = { "construcao", "medico", "comida", "esporte" };
		String[] vetDescricaoServico = { "tutu", "atta", "lorenipisulon", "1212" };

		// avaliador
		String[] vetNomeAvaliador = { "Beltrano 1", "Beltrano 2", "Beltrano 3" };
		String[] vetAvaliadorTelefone = { "Teste 1", "Teste 2", "Teste 3" };
		String[] vetEmailAvaliador = { "avaliador1@teste.com", "avaliador2@teste.com", "avaliador3@teste.com" };

		// avaliacao
		String[] vetDiagnostico = { "bom", "ruim", "medio" };
		int[] vetPontuacao = { 10, 2, 5 };
		String[] vetNivelAderencia = { "avaliador1@teste.com", "avaliador2@teste.com", "avaliador3@teste.com" };

		// Menu para Testes do CRUD
		do {
			System.out.println("\n");
			System.out.println("Menu:");
			System.out.println("1. Inserir Cliente");
			System.out.println("2. Pequisar um Cliente");
			System.out.println("3. Pesquisar Todos");
			System.out.println("4. Apagar um Cliente");
			System.out.println("5. Sair");

			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();

			switch (escolha) {

			// Insere clientes,avaliadores e avaliações no banco
			case 1:
			
				// cliente
				for (int i = 0; i < vetNomeCliente.length; i++) {
					c1.setCnpj(vetCnpjCliente[i]);
					c1.setNomeCliente(vetNomeCliente[i]);
					c1.setNomeEmpresa(vetNomeEmpresa[i]);
					c1.setIdContrato(vetIdContrato[i]);
					c1.setRazaoSocial(vetRazaoSocial[i]);
					c1.setNomeGestor(vetNomeGestor[i]);
					c1.setPontoFocal(vetPontoFocal[i]);
					c1.setTipoServico(vetTipoServico[i]);
					c1.setDescricaoServico(vetDescricaoServico[i]);
					c1.setEmailCliente(vetEmailCliente[i]);

					EntityManager em = JPAUtil.getEntityManager();
					em.getTransaction().begin();
					em.merge(c1);
					em.getTransaction().commit();
					em.close();
				}

				// avaliador
				for (int i = 0; i < vetNomeAvaliador.length; i++) {
					av.setEmailAvaliador(vetEmailAvaliador[i]);
					av.setNomeAvaliador(vetNomeAvaliador[i]);
					av.setTelefone(vetAvaliadorTelefone[i]);
					EntityManager em = JPAUtil.getEntityManager();
					em.getTransaction().begin();
					em.merge(av);
					em.getTransaction().commit();
					em.close();
				}

				// avaliacao
				for (int i = 0; i < vetDiagnostico.length; i++) {
					ava.setCliente(c1);
					ava.setDiagnostico(vetDiagnostico[i]);
					ava.setPontuacao(vetPontuacao[i]);
					ava.setNivelAderencia(vetNivelAderencia[i]);
					EntityManager em = JPAUtil.getEntityManager();
					em.getTransaction().begin();
					em.merge(ava);
					em.getTransaction().commit();
					em.close();
				} 
				break;

			// Pesquisa um cliente cadastrado pelo nome da empresa
			case 2:

				System.out.println("Pesquisar um Cliente/Empresa = ");
				nomeEmpresa = scanner.next();
				List<Cliente> clientes = cControl.pesquisarUmCliente(nomeEmpresa);
				if (!(clientes.isEmpty())) {
					for (Cliente cliente : clientes) {
						System.out.println("\n");
						System.out.println("Id= " + cliente.getIdCliente() + "\nCNPJ: " + cliente.getCnpj()
								+ "\nNome da empresa: " + cliente.getNomeEmpresa() + "\nResponsavel: "
								+ cliente.getNomeCliente() + "\nEmail: " + cliente.getEmailCliente());
					}
				} else
					System.out.println("Não encontrou o Cliente");
				scanner.nextLine();
				break;
				
			// Lista todos os clientes cadastrados
			case 3:

				System.out.println("Listando Todos os Clientes");
				clientes = cControl.pesquisarTodos();
				if (!(clientes.isEmpty())) {
					for (Cliente cliente : clientes) {
						System.out.println("\n");
						System.out.println("Id= " + cliente.getIdCliente() + "\nCNPJ: " + cliente.getCnpj()
								+ "\nNome da empresa: " + cliente.getNomeEmpresa() + "\nResponsavel: "
								+ cliente.getNomeCliente() + "Email: " + cliente.getEmailCliente());
					}
				} else
					System.out.println("Não encontrou o Cliente");
				break;

			// Apaga um cliente cadastrado do banco
			case 4:

				System.out.println("Escolha um Cliente para Apagar (ID) ");
				long id = scanner.nextLong();
				cControl.apagar(id);
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
