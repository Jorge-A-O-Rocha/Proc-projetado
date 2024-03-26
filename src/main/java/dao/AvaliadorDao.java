package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Avaliador;

public class AvaliadorDao implements IAvaliadorDao {
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory("HibJPA");


	@Override
	public Avaliador pesquisar(String avaliador) {
		return null;
	}

	@Override
	public void inserir(Avaliador avaliador) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(avaliador);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Avaliador avaliador = em.find(Avaliador.class, id);
		if (avaliador != null) {
			em.remove(avaliador);
		}
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Avaliador> lista() {
		EntityManager em = mf.createEntityManager();
		List<Avaliador> avaliadores = em.createQuery("SELECT av FROM Avaliador av", Avaliador.class).getResultList();
		em.close();
		return avaliadores;
	}

	@Override
	public List<Avaliador> apenasUmAvaliador(String nomeAvaliador) {
		EntityManager em = mf.createEntityManager();
		List<Avaliador> avaliadores = em
				.createQuery("SELECT av FROM Avaliador av WHERE av.nomeAvaliador LIKE :nomeAvaliador", Avaliador.class)
				.setParameter("nomeAvaliador", "%" + nomeAvaliador + "%").getResultList();
		em.close();
		return avaliadores;
	}

}
