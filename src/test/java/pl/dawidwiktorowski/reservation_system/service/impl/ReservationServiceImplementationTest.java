package pl.dawidwiktorowski.reservation_system.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import pl.dawidwiktorowski.reservation_system.config.TwilioConfiguration;
import pl.dawidwiktorowski.reservation_system.model.AppUser;
import pl.dawidwiktorowski.reservation_system.model.Reservation;
import pl.dawidwiktorowski.reservation_system.repository.ReservationRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class ReservationServiceImplementationTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private Reservation reservation;

    @Mock
    private AppUser appUser;

    @Mock
    private TwilioConfiguration twilioConfiguration;

    @Mock
    private EmailService emailService;

    @Captor
    private ArgumentCaptor<Reservation> captor;

    private ReservationServiceImplementation reservationServiceImplementation;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reservationServiceImplementation =
                new ReservationServiceImplementation(reservationRepository, twilioConfiguration, emailService);
    }

    @Test
    void shouldGetIdEquals3L() {
        // given
        when(reservation.getId()).thenReturn(3L);

        // when
        reservationServiceImplementation.save(reservation, appUser);

        // then

        verify(reservationRepository).save(captor.capture());

        Reservation reservation = captor.getValue();
        assertThat(reservation.getId()).isEqualTo(3L);

    }

    @Test
    void shouldStatusIsTrue() {
        // given
        when(reservation.isStatus()).thenReturn(true);

        // when
        reservationServiceImplementation.save(reservation, appUser);

        // then

        verify(reservationRepository).save(captor.capture());

        Reservation reservation = captor.getValue();
        assertThat(reservation.isStatus()).isEqualTo(true);

    }

    @Test
    void deleteReservation() {
    }

    @Disabled
    @Test
    void update() {
        // given


        // then

        // when
    }
}