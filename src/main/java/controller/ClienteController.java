package controller;

import java.util.List;


import dao.ClienteDao;
import model.Cliente;

public class ClienteController {
	ClienteDao clienteDao = new ClienteDao();
	
	public void inserirCliente (Cliente cliente){
		clienteDao.inserir(cliente);
	}
	
	public List<Cliente> pesquisarTodos (){
		return clienteDao.lista();
	}
	public List<Cliente> pesquisarUmCliente (String nomeEmpresa){
		return clienteDao.apenasUmCliente(nomeEmpresa);
	}
	
	public void apagar (long id) {
		clienteDao.remover(id);
	}
	
}
