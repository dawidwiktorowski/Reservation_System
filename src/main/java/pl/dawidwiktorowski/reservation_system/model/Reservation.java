package pl.dawidwiktorowski.reservation_system.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    public Reservation() {
    }

    public Reservation(Long id, boolean status, LocalDateTime dateTime, User user, SubCategory subCategory) {
        this.id = id;
        this.status = status;
        this.dateTime = dateTime;
        this.user = user;
        this.subCategory = subCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
