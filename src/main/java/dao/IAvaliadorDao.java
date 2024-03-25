package dao;

import java.util.List;

import model.Avaliador;

public interface IAvaliadorDao {
	public Avaliador pesquisar(String avaliador) ;
	public void inserir(Avaliador avaliador) ;
	public void remover (long id) ;
	public List<Avaliador> lista(); 
	public List<Avaliador> apenasUmAvaliador (String nomeAvaliador);
}
