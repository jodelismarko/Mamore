package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Funcao;

/**
 * DAO for Funcao
 */
@Stateless
public class FuncaoDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Funcao entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Funcao entity = em.find(Funcao.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Funcao findById(Integer id) {
        return em.find(Funcao.class, id);
    }

    public Funcao update(Funcao entity) {
        return em.merge(entity);
    }

    public List<Funcao> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Funcao> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT f FROM Funcao f LEFT JOIN FETCH f.desempenhos ORDER BY f.id",
                        Funcao.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
