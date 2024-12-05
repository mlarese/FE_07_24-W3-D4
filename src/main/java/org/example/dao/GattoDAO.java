package org.example.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.example.entity.Gatto;

import java.util.List;

@AllArgsConstructor
public class GattoDAO {
    private EntityManager em;

    public void save(Gatto  oggetto) {
        em.getTransaction().begin();
        em.persist(oggetto);
        em.getTransaction().commit();
    }

    public Gatto findById(Long id) {
        return em.find(Gatto.class, id);
    }

    public List<Gatto> findAll() {
        return em.createNamedQuery("Trova_tutto_Gatto", Gatto.class).getResultList();
    }
    
    public void update(Gatto oggetto) {
        em.getTransaction().begin();
        em.merge(oggetto);
        em.getTransaction().commit();
    }

    public void delete(Gatto oggetto) {
        em.getTransaction().begin();
        em.remove(oggetto);
        em.getTransaction().commit();
    }


}
