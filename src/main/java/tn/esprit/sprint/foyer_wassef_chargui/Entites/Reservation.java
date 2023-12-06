package tn.esprit.sprint.foyer_wassef_chargui.Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Table(name = "Reservation")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    String idReservation;

    @Column(name = "anneeUniversitaire")
    Date annee;

    @Column(name = "estValide")
    boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<Etudiant> etudiants;
}
