package pl.dawidwiktorowski.reservation_system.service;

import pl.dawidwiktorowski.reservation_system.model.AppUser;
import pl.dawidwiktorowski.reservation_system.model.Reservation;

import java.util.List;

public interface ReservationServiceInterface {
    void save(Reservation reservation, AppUser appUser);
    List<Reservation> showAllReservationWithStatusFalse();
    void confirmReservation(Long id);
    List<Reservation> showAllUserReservation(Long app_user_id);
    void deleteReservation(Long id);
    Reservation findById(Long id);
    void update(Reservation reservation);
}
