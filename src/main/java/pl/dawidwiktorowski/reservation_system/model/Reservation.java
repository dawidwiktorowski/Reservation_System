package pl.dawidwiktorowski.reservation_system.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status;

    private LocalDateTime dateTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private SubCategory subCategory;

}
