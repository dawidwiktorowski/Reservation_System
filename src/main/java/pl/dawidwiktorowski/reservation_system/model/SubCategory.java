package pl.dawidwiktorowski.reservation_system.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "subCategory")
    private List<Reservation> reservations;

    public SubCategory() {
    }

    public SubCategory(Long id, String name, double price, Category category, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
