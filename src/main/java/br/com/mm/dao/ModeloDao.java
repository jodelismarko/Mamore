package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Modelo;

/**
 * DAO for Modelo
 */
@Stateless
public class ModeloDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Modelo entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Modelo entity = em.find(Modelo.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Modelo findById(Integer id) {
        return em.find(Modelo.class, id);
    }

    public Modelo update(Modelo entity) {
        return em.merge(entity);
    }

    public List<Modelo> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Modelo> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT m FROM Modelo m LEFT JOIN FETCH m.celularCorporativos ORDER BY m.id",
                        Modelo.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
