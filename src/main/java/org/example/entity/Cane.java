package org.example.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;


// definisco la query per trovare tutti i cani e usarle nel dao
@NamedQuery(name = "Trova_tutto_Cane", query = "SELECT a FROM Cane a")
// definisco la query per trovare i cani con pedigree e usarle nel dao
@NamedQuery(name="Trova_cani_con_pedigree", query="SELECT a FROM Cane a WHERE a.haPedigree = :haPedigree")
@Data
@Entity
@Table(name = "cani")
public class Cane  extends Animale{
    private boolean haPedigree = false;
    private String razza;
}
