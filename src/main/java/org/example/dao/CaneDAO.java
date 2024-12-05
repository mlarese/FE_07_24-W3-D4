package org.example.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.example.entity.Cane;

import java.util.List;

@AllArgsConstructor
public class CaneDAO {
    private EntityManager em;

    // inserisce un oggetto passato per parametro
    public void save(Cane oggetto) {
        em.getTransaction().begin();
        em.persist(oggetto);
        em.getTransaction().commit();
    }

    // cerca un oggetto per id
    public Cane findById(Long id) {
        return em.find(Cane.class, id);
    }

    // cerca tutti i cani
    public List<Cane> findAll() {
        return em.createNamedQuery("Trova_tutto_Cane", Cane.class).getResultList();
    }

    // aggiorna un cane passato per parametro proveniente da un db
    // e quindi già dotato di id valorizzata
    public void update(Cane oggetto) {
        em.getTransaction().begin();
        em.merge(oggetto);
        em.getTransaction().commit();
    }

    // cancella un cane passato per parametro proveniente da un db
    public void delete(Cane oggetto) {
        em.getTransaction().begin();
        em.remove(oggetto);
        em.getTransaction().commit();
    }

    // cerca tutti i cani con pedigree usando la named query Trova_cani_con_pedigree
    public List<Cane> findByHasPedigree(Boolean haPedigree) {
        return em.createNamedQuery("Trova_cani_con_pedigree", Cane.class)
                .setParameter("haPedigree", haPedigree)
                .getResultList();
    }

    // cerca tutti i cani con pedigree usando una query dinamica
    // composta in base ai valori passati per parametro
    public List<Cane> findRazzaOPedigree ( String razza, Boolean haPedigree) {
        String sql = "SELECT a FROM Cane a WHERE ";
        if(razza!=null) {
            sql += "a.razza = :razza ";
            if(haPedigree!=null) {
                sql += "AND ";
            }
        }
        if(haPedigree!=null) {
            sql += "a.haPedigree = :haPedigree ";
        }

        Query query = em.createQuery(sql, Cane.class);


        if(razza!=null) {
            query.setParameter("razza", razza);
        }

        if(haPedigree!=null) {
            query.setParameter("haPedigree", haPedigree);
        }
        return query.getResultList();
    }

}
