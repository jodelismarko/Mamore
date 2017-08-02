package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Terceirizado;

/**
 * DAO for Terceirizado
 */
@Stateless
public class TerceirizadoDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Terceirizado entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Terceirizado entity = em.find(Terceirizado.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Terceirizado findById(Integer id) {
        return em.find(Terceirizado.class, id);
    }

    public Terceirizado update(Terceirizado entity) {
        return em.merge(entity);
    }

    public List<Terceirizado> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Terceirizado> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT t FROM Terceirizado t LEFT JOIN FETCH t.empresa LEFT JOIN FETCH t.servidor ORDER BY t.id",
                        Terceirizado.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
