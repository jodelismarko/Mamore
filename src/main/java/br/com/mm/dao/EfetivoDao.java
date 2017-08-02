package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Efetivo;

/**
 * DAO for Efetivo
 */
@Stateless
public class EfetivoDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Efetivo entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Efetivo entity = em.find(Efetivo.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Efetivo findById(Integer id) {
        return em.find(Efetivo.class, id);
    }

    public Efetivo update(Efetivo entity) {
        return em.merge(entity);
    }

    public List<Efetivo> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Efetivo> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT e FROM Efetivo e LEFT JOIN FETCH e.cargoEfetivo LEFT JOIN FETCH e.servidor LEFT JOIN FETCH e.desempenhos ORDER BY e.id",
                        Efetivo.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
