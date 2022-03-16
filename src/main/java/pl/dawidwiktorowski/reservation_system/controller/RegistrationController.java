package pl.dawidwiktorowski.reservation_system.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dawidwiktorowski.reservation_system.model.AppUser;
import pl.dawidwiktorowski.reservation_system.service.registration.RegistrationRequest;
import pl.dawidwiktorowski.reservation_system.service.registration.RegistrationService;

@Controller
@RequestMapping(path = "/")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @GetMapping("signUp")
    public String showFormRegister(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/api/v1/registration")
    public String register(@ModelAttribute AppUser appUser, @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName, @RequestParam("email") String email,
                           @RequestParam("password") String password, @RequestParam("phoneNumber") String phoneNumber) {

        RegistrationRequest registrationRequest = new RegistrationRequest(
                firstName, lastName, email, password, phoneNumber);

        registrationService.register(registrationRequest);
        return "redirect:/login";
    }

    @GetMapping("confirm")
    public String confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return "success_Confirmation";
    }
}