package dao;

import java.util.List;

import model.Cliente;

public interface IClienteDao {
	public Cliente pesquisar(String cliente) ;
	public void inserir(Cliente cliente) ;
	public void remover (long id) ;
	public List<Cliente> lista(); 
	public List<Cliente> apenasUmCliente (String nomeEmpresa);

}
