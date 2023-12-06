package tn.esprit.sprint.foyer_wassef_chargui.Services;

import tn.esprit.sprint.foyer_wassef_chargui.Entites.Chambre;

import java.util.List;

public interface ChambreService {
    List<Chambre> getAllChambres();
    Chambre addChambre(Chambre e);
    void removeChambre(long id);
    Chambre modifyChambre(Chambre e, long id);
}
