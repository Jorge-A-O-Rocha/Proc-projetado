package dao;
 
import java.util.List;
 
import model.Avaliacao;
 
public interface IAvaliacaoDao {
	public Avaliacao pesquisar(String avaliacao) ;
	public void inserir(Avaliacao avaliacao) ;
	public void remover (long id) ;
	public List<Avaliacao> lista();
	public List<Avaliacao> apenasUmaAvaliacao (String nomeAvaliador);
 
}
 