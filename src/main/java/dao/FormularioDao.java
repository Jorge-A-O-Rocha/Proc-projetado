package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Formulario;

public class FormularioDao implements IFormularioDao {
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory("HibJPA");


	@Override
	public Formulario pesquisar(String formulario) {
		return null;
	}

	@Override
	public void inserir(Formulario formulario) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(formulario);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Formulario forms = em.find(Formulario.class, id);
		if (forms != null) {
			em.remove(forms);
		}
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Formulario> lista() {
		EntityManager em = mf.createEntityManager();
		List<Formulario> formularios = em.createQuery("SELECT for FROM Formulario for", Formulario.class).getResultList();
		em.close();
		return formularios;
	}

	@Override
	public List<Formulario> apenasUmFormulario(String codForms) {
		EntityManager em = mf.createEntityManager();
		List<Formulario> forms = em
				.createQuery("SELECT for FROM Formulario for WHERE for.codForms LIKE :codForms", Formulario.class)
				.setParameter("codForms", "%" + codForms + "%").getResultList();
		em.close();
		return forms;
	}

}
