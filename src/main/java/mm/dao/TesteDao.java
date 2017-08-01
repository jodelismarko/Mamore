package mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mm.model.Teste;

/**
 * DAO for Teste
 */
@Stateless
public class TesteDao {
	@PersistenceContext(unitName = "celular_funcional-PU")
	private EntityManager em;

	public void create(Teste entity) {
		em.persist(entity);
	}

	public void deleteById(String id) {
		Teste entity = em.find(Teste.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Teste findById(String id) {
		return em.find(Teste.class, id);
	}

	public Teste update(Teste entity) {
		return em.merge(entity);
	}

	public List<Teste> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Teste> findAllQuery = em.createQuery(
				"SELECT DISTINCT t FROM Teste t ORDER BY t.nome", Teste.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
