package pl.dawidwiktorowski.reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/login")
    public String login(){
        return "form";
    }
}
