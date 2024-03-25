package controller;

import java.util.List;

import dao.AvaliadorDao;
import model.Avaliador;

public class AvaliadorController {
	AvaliadorDao avaliadorDao = new AvaliadorDao();

	public void inserirAvaliador(Avaliador avaliador) {
		avaliadorDao.inserir(avaliador);
	}

	public List<Avaliador> pesquisarTodos() {
		return avaliadorDao.lista();
	}

	public List<Avaliador> pesquisarUmAvaliador(String nomeAvaliador) {
		return avaliadorDao.apenasUmAvaliador(nomeAvaliador);
	}

	public void apagar(long id) {
		avaliadorDao.remover(id);
	}
}
