package br.com.mm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mm.model.Servidor;

/**
 * DAO for Servidor
 */
@Stateless
public class ServidorDao {
    @PersistenceContext(unitName = "celular_funcional-PU")
    private EntityManager em;

    public void create(Servidor entity) {
        em.persist(entity);
    }

    public void deleteById(Integer id) {
        Servidor entity = em.find(Servidor.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Servidor findById(Integer id) {
        return em.find(Servidor.class, id);
    }

    public Servidor update(Servidor entity) {
        return em.merge(entity);
    }

    public List<Servidor> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Servidor> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT s FROM Servidor s LEFT JOIN FETCH s.unidade LEFT JOIN FETCH s.efetivo LEFT JOIN FETCH s.disponibilizacaos LEFT JOIN FETCH s.comissionado LEFT JOIN FETCH s.terceirizado ORDER BY s.id",
                        Servidor.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
