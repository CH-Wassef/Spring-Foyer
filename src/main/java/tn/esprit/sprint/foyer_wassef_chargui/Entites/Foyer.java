package tn.esprit.sprint.foyer_wassef_chargui.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer;

    @Column(name = "nomFoyer")
    String nom;

    @Column(name = "capaciteFoyer")
    long capacite;

    @JsonIgnoreProperties("foyer")
    @OneToOne(mappedBy="foyer")
    Universite universite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    Set<Bloc> blocs;
}
