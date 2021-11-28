package pl.dawidwiktorowski.reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidwiktorowski.reservation_system.repository.UserRepository;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private UserRepository userRepository;

    @Autowired
    public ReservationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/show")
    public String showAll(Model model) {
        return "index";
    }

}
