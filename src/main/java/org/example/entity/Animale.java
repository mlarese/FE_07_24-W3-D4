package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "animali")
// tipo di ereditarietà SINGLE_TABLE
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// tipo di ereditarietà JOINED
// @Inheritance(strategy = InheritanceType.JOINED)
// tipo di ereditarietà TABLE_PER_CLASS
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


// tipo di ereditarietà da usare nella creazione delle tabelle
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

// crea una query per trovare tutti gli animali
@NamedQuery(name="Trova_tutto_Animale", query="SELECT a FROM Animale a")

public abstract class Animale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    private String nome;
    private Integer annoNascita;

}
