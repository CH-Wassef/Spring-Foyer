package tn.esprit.sprint.foyer_wassef_chargui.Services;

import tn.esprit.sprint.foyer_wassef_chargui.Entites.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();
    Etudiant addEtudiant(Etudiant e);
    void removeEtudiant(long id);
    Etudiant modifyEtudiant(Etudiant e, long id);

}
