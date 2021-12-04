package pl.dawidwiktorowski.reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {


    @RequestMapping("/")
    public String showAll() {
        return "index";
    }

}
