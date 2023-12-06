package tn.esprit.sprint.foyer_wassef_chargui.Services.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.sprint.foyer_wassef_chargui.Entites.Reservation;
import tn.esprit.sprint.foyer_wassef_chargui.Repositroy.ReservationRepository;
import tn.esprit.sprint.foyer_wassef_chargui.Services.ReservationService;

import java.util.List;

@Primary
@Service("ReservationServiceImpl")
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation e) {
        return reservationRepository.save(e);
    }

    @Override
    public void removeReservation(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation modifyReservation(Reservation updatedReservation, String id) {
        Reservation reservationToModify = reservationRepository.findById(id).orElse(null);

        if (reservationToModify != null) {
            reservationToModify.setAnnee(updatedReservation.getAnnee());
            reservationToModify.setEstValide(updatedReservation.isEstValide());

            return reservationRepository.save(reservationToModify);
        } else {
            throw new EntityNotFoundException("Reservation with ID " + id + " not found");
        }
    }

}
