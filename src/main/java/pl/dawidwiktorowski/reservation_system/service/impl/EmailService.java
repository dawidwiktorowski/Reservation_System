package pl.dawidwiktorowski.reservation_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.AppUser;
import pl.dawidwiktorowski.reservation_system.model.SubCategory;
import pl.dawidwiktorowski.reservation_system.service.EmailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailSender {

    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm a";
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String adminEmail;


    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Potwierdź swój email");
            helper.setFrom("dawid.wiktorowski22@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("Failed to send email");
        }
    }

    @Override
    @Async
    public void reservationRequestEmailSend(AppUser appUser, LocalDateTime dateTime, SubCategory subCategory) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(adminEmail);
            helper.setSubject("Rezerwacja");
            helper.setText(appUser.getFirstName() + " " + appUser.getLastName() + " chce zarezerwować miejsce na " + subCategory.getName() + " w dniu " + dateTimeFormatter.format(dateTime));
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("Failed to send email");
        }
    }

    @Async
    @Override
    public void sendEmailWhenUserUpdateReservation(AppUser appUser, LocalDateTime localDateTime, SubCategory subCategory) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(adminEmail);
            helper.setSubject("Zmiana rezerwacji");
            helper.setText(appUser.getFirstName() + " " + appUser.getLastName() + " chce zmienić usługę na " + subCategory.getName() + " w dniu " + dateTimeFormatter.format(localDateTime));
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("Failed to send email");
        }
    }

    @Async
    @Override
    public void sendEmailWhenUserDeleteReservation(AppUser appUser, LocalDateTime localDateTime, SubCategory subCategory) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(adminEmail);
            helper.setSubject("Rezygnacja z rezerwacji");
            helper.setText(appUser.getFirstName() + " " + appUser.getLastName() + " zrezygnował z usługi " + subCategory.getName() + " z dnia " + dateTimeFormatter.format(localDateTime));
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("Failed to send email");
        }
    }
}