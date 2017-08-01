package mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mm.model.CargoEfetivo;

/**
 * DAO for CargoEfetivo
 */
@Stateless
public class CargoEfetivoDao {
	@PersistenceContext(unitName = "celular_funcional-PU")
	private EntityManager em;

	public void create(CargoEfetivo entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		CargoEfetivo entity = em.find(CargoEfetivo.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public CargoEfetivo findById(Integer id) {
		return em.find(CargoEfetivo.class, id);
	}

	public CargoEfetivo update(CargoEfetivo entity) {
		return em.merge(entity);
	}

	public List<CargoEfetivo> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<CargoEfetivo> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM CargoEfetivo c LEFT JOIN FETCH c.efetivos ORDER BY c.id",
						CargoEfetivo.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
