package tn.esprit.sprint.foyer_wassef_chargui.Entites;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Table(name = "Universite")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;
    @Column(name = "nomUniversite")
    String nom;
    @Column(name = "adresse")
    String adresse;

    @OneToOne
    Foyer foyer;

}
