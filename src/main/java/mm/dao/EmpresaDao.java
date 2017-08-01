package mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mm.model.Empresa;

/**
 * DAO for Empresa
 */
@Stateless
public class EmpresaDao {
	@PersistenceContext(unitName = "celular_funcional-PU")
	private EntityManager em;

	public void create(Empresa entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Empresa entity = em.find(Empresa.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Empresa findById(Integer id) {
		return em.find(Empresa.class, id);
	}

	public Empresa update(Empresa entity) {
		return em.merge(entity);
	}

	public List<Empresa> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Empresa> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM Empresa e LEFT JOIN FETCH e.terceirizados ORDER BY e.id",
						Empresa.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
