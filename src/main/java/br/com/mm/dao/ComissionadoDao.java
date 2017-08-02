package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Comissionado;

/**
 * DAO for Comissionado
 */
@Stateless
public class ComissionadoDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Comissionado entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Comissionado entity = em.find(Comissionado.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Comissionado findById(Integer id) {
        return em.find(Comissionado.class, id);
    }

    public Comissionado update(Comissionado entity) {
        return em.merge(entity);
    }

    public List<Comissionado> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Comissionado> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT c FROM Comissionado c LEFT JOIN FETCH c.cargoComissionado LEFT JOIN FETCH c.servidor ORDER BY c.id",
                        Comissionado.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
