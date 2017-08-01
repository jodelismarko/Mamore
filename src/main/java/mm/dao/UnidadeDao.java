package mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mm.model.Unidade;

/**
 * DAO for Unidade
 */
@Stateless
public class UnidadeDao {
	@PersistenceContext(unitName = "celular_funcional-PU")
	private EntityManager em;

	public void create(Unidade entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Unidade entity = em.find(Unidade.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Unidade findById(Integer id) {
		return em.find(Unidade.class, id);
	}

	public Unidade update(Unidade entity) {
		return em.merge(entity);
	}

	public List<Unidade> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Unidade> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT u FROM Unidade u LEFT JOIN FETCH u.servidors ORDER BY u.id",
						Unidade.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
