package controller;

import java.util.List;

import dao.FormularioDao;
import model.Formulario;

public class FormularioController {
	FormularioDao formularioDao = new FormularioDao();

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
}
