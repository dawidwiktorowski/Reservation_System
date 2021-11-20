package pl.dawidwiktorowski.reservation_system.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String phoneNumber;

    private boolean active;

    @OneToOne
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
}
