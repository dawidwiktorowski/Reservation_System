package pl.dawidwiktorowski.reservation_system.service;

import org.springframework.scheduling.annotation.Async;
import pl.dawidwiktorowski.reservation_system.model.AppUser;
import pl.dawidwiktorowski.reservation_system.model.SubCategory;

import java.time.LocalDateTime;

public interface EmailSender {
    void send(String to, String email);

    void reservationRequestEmailSend(AppUser appUser, LocalDateTime dateTime, SubCategory subCategory);

    void sendEmailWhenUserUpdateReservation(AppUser appUser, LocalDateTime localDateTime, SubCategory subCategory);

    @Async
    void sendEmailWhenUserDeleteReservation(AppUser appUser, LocalDateTime localDateTime, SubCategory subCategory);
}