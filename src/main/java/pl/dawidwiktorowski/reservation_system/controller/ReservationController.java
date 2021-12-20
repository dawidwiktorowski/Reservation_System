package pl.dawidwiktorowski.reservation_system.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dawidwiktorowski.reservation_system.model.AppUser;
import pl.dawidwiktorowski.reservation_system.model.Category;
import pl.dawidwiktorowski.reservation_system.model.Reservation;
import pl.dawidwiktorowski.reservation_system.service.CategoryServiceInterface;
import pl.dawidwiktorowski.reservation_system.service.ReservationServiceInterface;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/reservation")
@AllArgsConstructor
public class ReservationController {

    private final CategoryServiceInterface categoryServiceInterface;

    private final ReservationServiceInterface reservationServiceInterface;


    @GetMapping(value = "/addReservation")
    public String showReservationForm(Model model) {
        List<Category> categories = categoryServiceInterface.findAll();
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("categoryList", categories);
        return "reservation/reservationForm";
    }

    @PostMapping(value = "/addReservation")
    public String addReservation(@ModelAttribute Reservation reservation, Principal principal) {
        AppUser appUser = getUser(principal);
        reservationServiceInterface.save(reservation, appUser);
        return "redirect:/";
    }

    @GetMapping(value = "/userReservation")
    public String showUserReservationsForm(Principal principal, Model model) {
        AppUser appUser = getUser(principal);
        List<Reservation> reservations = reservationServiceInterface.showAllUserReservation(appUser.getId());
        model.addAttribute("userReservations", reservations);
        return "reservation/userReservationForm";
    }

    @GetMapping(value = "/editReservation/{id}")
    public String showEditReservationForm(@PathVariable("id") Long reservationId, Model model) {
        Reservation reservation = reservationServiceInterface.findById(reservationId);
        List<Category> categories = categoryServiceInterface.findAll();
        model.addAttribute("categoryList", categories);
        model.addAttribute("editReservation", reservation);
        return "reservation/editReservationForm";
    }

    @PostMapping(value = "/editReservation/{id}")
    public String editReservation(@ModelAttribute Reservation reservation) {
        reservationServiceInterface.update(reservation);
        return "redirect:/reservation/userReservation";
    }

    private AppUser getUser(Principal principal) {
        return null;
    }

}
