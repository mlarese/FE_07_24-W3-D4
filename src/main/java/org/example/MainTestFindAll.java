package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.AnimaleDAO;
import org.example.dao.CaneDAO;

import java.util.Locale;

public class MainTestFindAll {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();


        // uso il DAO per le operazioni di lettura
        CaneDAO caneDAO = new CaneDAO(em);
        AnimaleDAO animaleDAO = new AnimaleDAO(em);
        // estrapolo tutti gli animali
        // System.out.println(animaleDAO.findAll());

        // trova tutti i cani
        System.out.println(caneDAO.findAll());

        // trova cani con pedigree
        System.out.println("----------------- con pedigree");
        System.out.println(caneDAO.findByHasPedigree(true));
        System.out.println("----------------- senza pedigree");
        System.out.println(caneDAO.findByHasPedigree(false));
    }
}