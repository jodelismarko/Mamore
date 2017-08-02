package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.AssociacaoLinhaChip;

/**
 * DAO for AssociacaoLinhaChip
 */
@Stateless
public class AssociacaoLinhaChipDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(AssociacaoLinhaChip entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        AssociacaoLinhaChip entity = em.find(AssociacaoLinhaChip.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public AssociacaoLinhaChip findById(Integer id) {
        return em.find(AssociacaoLinhaChip.class, id);
    }

    public AssociacaoLinhaChip update(AssociacaoLinhaChip entity) {
        return em.merge(entity);
    }

    public List<AssociacaoLinhaChip> listAll(Integer startPosition,
                                             Integer maxResult) {
        TypedQuery<AssociacaoLinhaChip> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT a FROM AssociacaoLinhaChip a LEFT JOIN FETCH a.chip LEFT JOIN FETCH a.linha ORDER BY a.id",
                        AssociacaoLinhaChip.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
