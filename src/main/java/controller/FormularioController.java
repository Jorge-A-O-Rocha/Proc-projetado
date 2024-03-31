package controller;

import java.util.List;
import java.util.Scanner;

import dao.FormularioDao;
import model.Cliente;
import model.Formulario;

public class FormularioController {
	FormularioDao formularioDao = new FormularioDao();
	Scanner scanner = new Scanner(System.in);


	public void inserirFormulario(Formulario formulario) {
		formularioDao.inserir(formulario);
	}

	public List<Formulario> pesquisarTodos() {
		return formularioDao.lista();
	}

	public List<Formulario> pesquisarUmAvaliador(String codForms) {
		return formularioDao.apenasUmFormulario(codForms);
	}

	public void apagar(long id) {
		formularioDao.remover(id);
	}
	
	public Formulario preencherFormulario (Cliente cliente) {

		Formulario formulario = new Formulario();
		int[] vetRespostasForms = new int[18];

		for(int i=0; i<18;i++) {

			formulario.setIdFormulario(i+1);
			formulario.setCliente(cliente);
			System.out.println("Pergunta " + (i+1) + " /nPossui algum controle sobre o assunto? "+ "\n1-sim 2-não");
			int possuiOuNao = scanner.nextInt();
			if(possuiOuNao == 1) {
				formulario.setPossuiControle(true);
				
				System.out.println("Pergunta " + (i+1) + " /nde 1 - 5 qual o nível de maturidade desse processo? ");
				int nivelMaturidade = scanner.nextInt();
				vetRespostasForms[i]= nivelMaturidade;

			}else {
				formulario.setPossuiControle(false);
				vetRespostasForms[i]= 0;
			}
		}
		formulario.setRespostaFinal(vetRespostasForms);
		return formulario;
	}
}
