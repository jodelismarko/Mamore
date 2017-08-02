package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Linha;

/**
 * DAO for Linha
 */
@Stateless
public class LinhaDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Linha entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Linha entity = em.find(Linha.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Linha findById(Integer id) {
        return em.find(Linha.class, id);
    }

    public Linha update(Linha entity) {
        return em.merge(entity);
    }

    public List<Linha> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Linha> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT l FROM Linha l LEFT JOIN FETCH l.disponibilizacaos LEFT JOIN FETCH l.associacaoLinhaChips ORDER BY l.id",
                        Linha.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
