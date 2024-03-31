package controller;

import java.util.List;

import dao.AvaliacaoDao;
import model.Avaliacao;
import model.Formulario;

public class AvaliacaoController {
	AvaliacaoDao avaliacaoDao = new AvaliacaoDao();

	public void inserirAvaliacao(Avaliacao avaliacao) {
		avaliacaoDao.inserir(avaliacao);
	}

	public List<Avaliacao> pesquisarTodos() {
		return avaliacaoDao.lista();
	}

	public List<Avaliacao> pesquisarUmaAvaliacao(long idAvaliacao) {
		return avaliacaoDao.apenasUmaAvaliacao(idAvaliacao);
	}

	public void apagar(long id) {
		avaliacaoDao.remover(id);
	}

	public String gerarDiagnostico(Formulario forms) {

		int pontuacao = gerarPontuacao(forms);
		String diagnostico;
		// testes de inserção de nivel de aderencia
		if (pontuacao >= 4) {
			diagnostico = "Está tudo automatizado, auditado, registrado e seguro no nível máximo de maturidade de segurança";
			return diagnostico;
		}

		else if (pontuacao <= 2) {
			diagnostico = "falta uma definição de processo para ser auditado";
			return diagnostico;
		}

		else {
			diagnostico = "É preciso automatizar os processos para poder subir para o próximo nível de maturidade de segurança";
			return diagnostico;
		}

	}

	public int gerarPontuacao(Formulario forms) {
		// teste de calculo de pontuação
		int pontuacao = 0;
		int vetResposta[] = forms.getVetResposta();

		for (int i = 0; i < forms.getVetResposta().length; i++) {
			pontuacao = pontuacao + vetResposta[i];
		}

		return pontuacao / 18;
	}

	public String gerarNivelAderencia(Formulario forms) {

		int pontuacao = gerarPontuacao(forms);
		String nivelAderencia;
		// testes de inserção de nivel de aderencia
		if (pontuacao >= 4) {
			nivelAderencia = "Nível 3 de maturidade de segurança";
			return nivelAderencia;
		}

		else if (pontuacao <= 2) {
			nivelAderencia = "Nível 1 de maturidade de segurança";
			return nivelAderencia;
		}

		else {
			nivelAderencia = "Nível 2 de maturidade de segurança";
			return nivelAderencia;
		}

	}

}