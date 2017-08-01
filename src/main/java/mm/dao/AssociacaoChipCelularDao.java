package mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mm.model.AssociacaoChipCelular;

/**
 * DAO for AssociacaoChipCelular
 */
@Stateless
public class AssociacaoChipCelularDao {
	@PersistenceContext(unitName = "celular_funcional-PU")
	private EntityManager em;

	public void create(AssociacaoChipCelular entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		AssociacaoChipCelular entity = em.find(AssociacaoChipCelular.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public AssociacaoChipCelular findById(Integer id) {
		return em.find(AssociacaoChipCelular.class, id);
	}

	public AssociacaoChipCelular update(AssociacaoChipCelular entity) {
		return em.merge(entity);
	}

	public List<AssociacaoChipCelular> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<AssociacaoChipCelular> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT a FROM AssociacaoChipCelular a LEFT JOIN FETCH a.celular LEFT JOIN FETCH a.chip ORDER BY a.id",
						AssociacaoChipCelular.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
