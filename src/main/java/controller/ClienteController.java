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
	
	public void login () {
		System.out.println("Informe o seu email e senha");
	}
	
	public void cadastro() {
		System.out.println("Informe o seu email e senha");
		Cliente cli = new Cliente();
		cli.setEmail("");
		cli.setSenha("");
	}
	
	public void Contrato() {
		System.out.println("ligue para 1199889999");
	}
	
}
