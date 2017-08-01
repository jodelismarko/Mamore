package mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mm.model.CelularParticular;

/**
 * DAO for CelularParticular
 */
@Stateless
public class CelularParticularDao {
	@PersistenceContext(unitName = "celular_funcional-PU")
	private EntityManager em;

	public void create(CelularParticular entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		CelularParticular entity = em.find(CelularParticular.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public CelularParticular findById(Integer id) {
		return em.find(CelularParticular.class, id);
	}

	public CelularParticular update(CelularParticular entity) {
		return em.merge(entity);
	}

	public List<CelularParticular> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<CelularParticular> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM CelularParticular c LEFT JOIN FETCH c.celular ORDER BY c.id",
						CelularParticular.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
