package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Disponibilizacao;

/**
 * DAO for Disponibilizacao
 */
@Stateless
public class DisponibilizacaoDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Disponibilizacao entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Disponibilizacao entity = em.find(Disponibilizacao.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Disponibilizacao findById(Integer id) {
        return em.find(Disponibilizacao.class, id);
    }

    public Disponibilizacao update(Disponibilizacao entity) {
        return em.merge(entity);
    }

    public List<Disponibilizacao> listAll(Integer startPosition,
                                          Integer maxResult) {
        TypedQuery<Disponibilizacao> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT d FROM Disponibilizacao d LEFT JOIN FETCH d.linha LEFT JOIN FETCH d.servidor ORDER BY d.id",
                        Disponibilizacao.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
