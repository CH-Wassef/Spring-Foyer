package tn.esprit.sprint.foyer_wassef_chargui.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.sprint.foyer_wassef_chargui.Entites.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
}
