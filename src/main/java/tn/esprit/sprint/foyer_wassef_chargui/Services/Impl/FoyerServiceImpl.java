package tn.esprit.sprint.foyer_wassef_chargui.Services.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.sprint.foyer_wassef_chargui.Entites.Foyer;
import tn.esprit.sprint.foyer_wassef_chargui.Repositroy.FoyerRepository;
import tn.esprit.sprint.foyer_wassef_chargui.Services.FoyerService;

import java.util.List;

@Primary
@Service("FoyerServiceImpl")
@AllArgsConstructor
public class FoyerServiceImpl implements FoyerService {
    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer e) {
        return foyerRepository.save(e);
    }

    @Override
    public void removeFoyer(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer modifyFoyer(Foyer updatedFoyer, long id) {
        Foyer foyerToModify = foyerRepository.findById(id).orElse(null);

        if (foyerToModify != null) {
            foyerToModify.setNom(updatedFoyer.getNom());
            foyerToModify.setCapacite(updatedFoyer.getCapacite());

            return foyerRepository.save(foyerToModify);
        } else {
            throw new EntityNotFoundException("Foyer with ID " + id + " not found");
        }
    }

}
