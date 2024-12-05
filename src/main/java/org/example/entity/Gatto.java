package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Trova_tutto_Gatto", query = "SELECT a FROM Gatto a")
public class Gatto extends Animale {
     private String tipoPelo;

}
