package pl.dawidwiktorowski.reservation_system.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.AppUser;
import pl.dawidwiktorowski.reservation_system.model.Reservation;
import pl.dawidwiktorowski.reservation_system.repository.ReservationRepository;
import pl.dawidwiktorowski.reservation_system.service.ReservationServiceInterface;

import javax.mail.Message;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImplementation implements ReservationServiceInterface {

    private ReservationRepository reservationRepository;


    @Override
    public void save(Reservation reservation, AppUser appUser) {
        reservation.setStatus(false);
        reservation.setAppUser(appUser);
        reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> showAllReservationWithStatusFalse() {
        return reservationRepository.findAllByStatusFalse();
    }

    @Override
    public void confirmReservation(Long id) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
        reservationRepository.findById(id).ifPresent(x -> {
            x.setStatus(true);
        });

    }

    @Override
    public List<Reservation> showAllUserReservation(Long app_user_id) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {

    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Reservation reservation) {

    }
}
