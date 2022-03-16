package pl.dawidwiktorowski.reservation_system.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @OneToMany(mappedBy = "subCategory")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
