package tn.esprit.sprint.foyer_wassef_chargui.Services.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.sprint.foyer_wassef_chargui.Entites.Bloc;
import tn.esprit.sprint.foyer_wassef_chargui.Repositroy.BlockRepository;
import tn.esprit.sprint.foyer_wassef_chargui.Services.IBlockService;

import java.util.List;

@Primary
@Service("BlockServiceImpl")
@AllArgsConstructor
public class BlockServiceImpl implements IBlockService {
    BlockRepository blockRepository;

    @Override
    public List<Bloc> getAllBlocks() {
        return blockRepository.findAll();
    }

    @Override
    public Bloc addBlock(Bloc e) {
        return blockRepository.save(e);
    }

    @Override
    public void removeBlock(long id) {
        blockRepository.deleteById(id);
    }

    @Override
    public Bloc modifyBlock(Bloc e, long id) {
        Bloc blocToModify = blockRepository.findById(id).orElse(null);

        if (blocToModify != null) {
            blocToModify.setNom(e.getNom());
            blocToModify.setCapacite(e.getCapacite());

            return blockRepository.save(blocToModify);
        } else {
            throw new EntityNotFoundException("Bloc with ID " + id + " not found");
        }
    }
}
