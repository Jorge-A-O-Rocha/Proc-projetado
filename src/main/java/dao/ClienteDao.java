package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class ClienteDao implements IClienteDao {

	EntityManagerFactory mf = Persistence.createEntityManagerFactory("HibJPA");

	@Override
	public Cliente pesquisar(String cliente) {
		return null;
	}

	@Override
	public void inserir(Cliente cliente) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		if (cliente != null) {
			em.remove(cliente);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Cliente> lista() {
		EntityManager em = mf.createEntityManager();
		List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
		em.close();
		return clientes;
	}

	@Override
	public List<Cliente> apenasUmCliente(String nomeEmpresa) {
		EntityManager em = mf.createEntityManager();
		List<Cliente> clientes = em
				.createQuery("SELECT c FROM Cliente c WHERE c.nomeEmpresa LIKE :nomeEmpresa", Cliente.class)
				.setParameter("nomeEmpresa", "%" + nomeEmpresa + "%").getResultList();
		em.close();
		return clientes;
	}

}
