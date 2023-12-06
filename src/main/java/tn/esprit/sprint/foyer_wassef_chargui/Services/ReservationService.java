package tn.esprit.sprint.foyer_wassef_chargui.Services;

import tn.esprit.sprint.foyer_wassef_chargui.Entites.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Reservation addReservation(Reservation e);
    void removeReservation(String id);
    Reservation modifyReservation(Reservation e, String id);
}
