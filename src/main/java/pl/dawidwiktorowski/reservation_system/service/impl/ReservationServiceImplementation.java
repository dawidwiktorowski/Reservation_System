package pl.dawidwiktorowski.reservation_system.service.impl;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.config.TwilioConfiguration;
import pl.dawidwiktorowski.reservation_system.model.AppUser;
import pl.dawidwiktorowski.reservation_system.model.Reservation;
import pl.dawidwiktorowski.reservation_system.repository.ReservationRepository;
import pl.dawidwiktorowski.reservation_system.service.ReservationServiceInterface;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImplementation implements ReservationServiceInterface {

    private ReservationRepository reservationRepository;

    private TwilioConfiguration twilioConfiguration;

    private final EmailService emailService;


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
            Message.creator(
                    new PhoneNumber(x.getAppUser().getPhoneNumber()),
                    new PhoneNumber(twilioConfiguration.getTrialNumber()),
                    "Twoja rezerwacja na : " + x.getSubCategory().getName() + " w dniu "
                    + dateTimeFormatter.format(x.getDateTime()) + " jest przyjęta").create();
            reservationRepository.save(x);
        });

    }

    @Override
    public List<Reservation> showAllUserReservation(Long app_user_id) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.findById(id).ifPresent(reservation -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
            Message.creator(
                    new PhoneNumber(reservation.getAppUser().getPhoneNumber()),
                    new PhoneNumber(twilioConfiguration.getTrialNumber()),
                    "Twoja rezerwacja na: " + reservation.getSubCategory().getName() + " w dniu "
                    + dateTimeFormatter.format(reservation.getDateTime()) + " była odwołana").create();
            reservationRepository.delete(reservation);
        });

    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Reservation reservation) {

    }
}
