package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coleotteri")
public class Coleottero extends Animale{
    private String famiglia;
    private String colore;

}
