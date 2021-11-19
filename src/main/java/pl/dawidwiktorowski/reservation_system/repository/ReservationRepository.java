package pl.dawidwiktorowski.reservation_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidwiktorowski.reservation_system.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
