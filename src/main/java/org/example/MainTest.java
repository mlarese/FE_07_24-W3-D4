package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Cane;
import org.example.entity.Coleottero;

import java.util.Locale;

public class MainTest {
    public static void main(String[] args) {
        // dati fasulli
        Faker faker = new Faker(new Locale("it"));
        // creazione di un EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        for (int i = 0; i < 10; i++) {
            // creazione di un cane
            Cane cane = new Cane();
            cane.setNome(faker.animal().name());
            cane.setAnnoNascita(faker.number().numberBetween(2000, 2021));
            cane.setHaPedigree(faker.bool().bool());
            cane.setRazza(faker.dog().breed());

            // creazione di un coleottero
            Coleottero coleottero = new Coleottero();
            coleottero.setFamiglia(faker.animal().name());
            coleottero.setColore(faker.color().name());
            coleottero.setNome(faker.animal().name());

            // inizio della transazione
            em.getTransaction().begin();
            // persistenza dell'oggetto cane
            em.persist(cane);
            // persistenza dell'oggetto coleottero
            em.persist(coleottero);
            // fine della transazione
            em.getTransaction().commit();
        }

    }
}