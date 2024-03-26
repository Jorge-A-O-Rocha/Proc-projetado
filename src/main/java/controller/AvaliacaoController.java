package controller;
 
import java.util.List;
 
import dao.AvaliacaoDao;
import model.Avaliacao;
 
public class AvaliacaoController {
AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
	
	public void inserirAvaliacao (Avaliacao avaliacao){
		avaliacaoDao.inserir(avaliacao);
	}
	
	public List<Avaliacao> pesquisarTodos (){
		return avaliacaoDao.lista();
	}
	public List<Avaliacao> pesquisarUmaAvaliacao (String idAvaliacao){
		return avaliacaoDao.apenasUmaAvaliacao(idAvaliacao);
	}
	
	public void apagar (long idAvaliacao) {
		avaliacaoDao.remover(idAvaliacao);
	}
 
}