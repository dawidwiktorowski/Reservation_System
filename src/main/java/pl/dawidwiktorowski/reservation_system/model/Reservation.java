package pl.dawidwiktorowski.reservation_system.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", nullable = false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;

    private boolean status;

    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime dateTime;
}
