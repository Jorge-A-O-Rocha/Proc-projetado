package dao;
 
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import model.Avaliacao;
 
public class AvaliacaoDao implements IAvaliacaoDao{
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory("HibJPA");
 
	@Override
	public Avaliacao pesquisar(String avaliacao) {
		return null;
	}
 
	@Override
	public void inserir(Avaliacao avaliacao) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(avaliacao);
		em.getTransaction().commit();
		em.close();
		
	}
 
 
	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Avaliacao avaliacao = em.find(Avaliacao.class, id);
		if (avaliacao != null) {
			em.remove(avaliacao);
		}
		em.getTransaction().commit();
		em.close();
		
	}
 
	@Override
	public List<Avaliacao> lista() {
		EntityManager em = mf.createEntityManager();
		List<Avaliacao> avaliacoes = em.createQuery("SELECT ava FROM Avaliacao ava", Avaliacao.class).getResultList();
		em.close();
		return avaliacoes;
	}
 
	@Override
	public List<Avaliacao> apenasUmaAvaliacao(String idAvaliacao) {
		EntityManager em = mf.createEntityManager();
		List<Avaliacao> avaliacoes = em
				.createQuery("SELECT ava FROM Avaliacao av WHERE av.idAvaliacao LIKE :idAvaliacao", Avaliacao.class)
				.setParameter("idAvaliacao", "%" + idAvaliacao + "%").getResultList();
		em.close();
		return avaliacoes;
	}
 
	
 
 
}
 