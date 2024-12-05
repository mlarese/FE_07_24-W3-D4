package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.CaneDAO;

import java.util.Locale;

public class MainQueryDinamiche {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();


        CaneDAO caneDAO = new CaneDAO(em);

        // cerco solo per pedigree
        System.out.println( caneDAO.findRazzaOPedigree( null, true )  );

        // cerco solo per pedigree
        System.out.println( caneDAO.findRazzaOPedigree( "Bouvier", null )  );

        System.out.println( caneDAO.findRazzaOPedigree( "Bouvier", true )  );

    }
}