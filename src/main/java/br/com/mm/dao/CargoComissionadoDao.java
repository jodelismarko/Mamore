package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.CargoComissionado;

/**
 * DAO for CargoComissionado
 */
@Stateless
public class CargoComissionadoDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(CargoComissionado entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        CargoComissionado entity = em.find(CargoComissionado.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public CargoComissionado findById(Integer id) {
        return em.find(CargoComissionado.class, id);
    }

    public CargoComissionado update(CargoComissionado entity) {
        return em.merge(entity);
    }

    public List<CargoComissionado> listAll(Integer startPosition,
                                           Integer maxResult) {
        TypedQuery<CargoComissionado> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT c FROM CargoComissionado c LEFT JOIN FETCH c.comissionados LEFT JOIN FETCH c.desempenhos ORDER BY c.id",
                        CargoComissionado.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
