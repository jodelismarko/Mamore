package mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mm.model.Chip;

/**
 * DAO for Chip
 */
@Stateless
public class ChipDao {
	@PersistenceContext(unitName = "celular_funcional-PU")
	private EntityManager em;

	public void create(Chip entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Chip entity = em.find(Chip.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Chip findById(Integer id) {
		return em.find(Chip.class, id);
	}

	public Chip update(Chip entity) {
		return em.merge(entity);
	}

	public List<Chip> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Chip> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Chip c LEFT JOIN FETCH c.associacaoLinhaChips LEFT JOIN FETCH c.associacaoChipCelulars ORDER BY c.id",
						Chip.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
