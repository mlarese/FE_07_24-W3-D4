package org.example.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.example.entity.Animale;

import java.util.List;

@AllArgsConstructor
public class AnimaleDAO {
    private EntityManager em;

    public void save(Animale oggetto) {
        em.getTransaction().begin();
        em.persist(oggetto);
        em.getTransaction().commit();
    }

    public List<Animale> findAll() {
        return em.createNamedQuery("Trova_tutto_Animale", Animale.class).getResultList();
    }


    public Animale findById(Long id) {
        return em.find(Animale.class, id);
    }

    public void update(Animale oggetto) {
        em.getTransaction().begin();
        em.merge(oggetto);
        em.getTransaction().commit();
    }

    public void delete(Animale oggetto) {
        em.getTransaction().begin();
        em.remove(oggetto);
        em.getTransaction().commit();
    }


}
