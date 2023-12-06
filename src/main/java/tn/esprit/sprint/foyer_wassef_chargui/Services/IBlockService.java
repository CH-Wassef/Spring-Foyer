package tn.esprit.sprint.foyer_wassef_chargui.Services;

import tn.esprit.sprint.foyer_wassef_chargui.Entites.Bloc;

import java.util.List;

public interface IBlockService {
    List<Bloc> getAllBlocks();
    Bloc addBlock(Bloc e);
    void removeBlock(long id);
    Bloc modifyBlock(Bloc e, long id);
}
