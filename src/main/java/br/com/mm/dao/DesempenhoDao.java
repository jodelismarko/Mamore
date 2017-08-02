package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Desempenho;

/**
 * DAO for Desempenho
 */
@Stateless
public class DesempenhoDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Desempenho entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Desempenho entity = em.find(Desempenho.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Desempenho findById(Integer id) {
        return em.find(Desempenho.class, id);
    }

    public Desempenho update(Desempenho entity) {
        return em.merge(entity);
    }

    public List<Desempenho> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Desempenho> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT d FROM Desempenho d LEFT JOIN FETCH d.cargoComissionado LEFT JOIN FETCH d.efetivo LEFT JOIN FETCH d.funcao ORDER BY d.id",
                        Desempenho.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
