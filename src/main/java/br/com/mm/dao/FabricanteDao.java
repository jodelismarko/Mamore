package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Fabricante;

/**
 * DAO for Fabricante
 */
@Stateless
public class FabricanteDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Fabricante entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Fabricante entity = em.find(Fabricante.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Fabricante findById(Integer id) {
        return em.find(Fabricante.class, id);
    }

    public Fabricante update(Fabricante entity) {
        return em.merge(entity);
    }

    public List<Fabricante> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Fabricante> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT f FROM Fabricante f LEFT JOIN FETCH f.celularCorporativos ORDER BY f.id",
                        Fabricante.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
