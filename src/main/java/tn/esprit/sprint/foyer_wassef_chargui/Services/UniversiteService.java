package tn.esprit.sprint.foyer_wassef_chargui.Services;

import tn.esprit.sprint.foyer_wassef_chargui.Entites.Universite;

import java.util.List;

public interface UniversiteService {
    List<Universite> getAllUniversites();
    Universite addUniversite(Universite e);
    void removeUniversite(long id);
    Universite modifyUniversite(Universite e, long id);
}
