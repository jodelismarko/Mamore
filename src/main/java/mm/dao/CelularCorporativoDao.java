package mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mm.model.CelularCorporativo;

/**
 * DAO for CelularCorporativo
 */
@Stateless
public class CelularCorporativoDao {
	@PersistenceContext(unitName = "celular_funcional-PU")
	private EntityManager em;

	public void create(CelularCorporativo entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		CelularCorporativo entity = em.find(CelularCorporativo.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public CelularCorporativo findById(Integer id) {
		return em.find(CelularCorporativo.class, id);
	}

	public CelularCorporativo update(CelularCorporativo entity) {
		return em.merge(entity);
	}

	public List<CelularCorporativo> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<CelularCorporativo> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM CelularCorporativo c LEFT JOIN FETCH c.celular LEFT JOIN FETCH c.fabricante LEFT JOIN FETCH c.modelo ORDER BY c.id",
						CelularCorporativo.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
