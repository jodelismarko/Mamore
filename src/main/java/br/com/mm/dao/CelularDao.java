package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Celular;

/**
 * DAO for Celular
 */
@Stateless
public class CelularDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Celular entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Celular entity = em.find(Celular.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Celular findById(Integer id) {
        return em.find(Celular.class, id);
    }

    public Celular update(Celular entity) {
        return em.merge(entity);
    }

    public List<Celular> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Celular> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT c FROM Celular c LEFT JOIN FETCH c.celularParticular LEFT JOIN FETCH c.celularCorporativo LEFT JOIN FETCH c.associacaoChipCelulars ORDER BY c.id",
                        Celular.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
