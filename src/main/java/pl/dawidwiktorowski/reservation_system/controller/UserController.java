package pl.dawidwiktorowski.reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dawidwiktorowski.reservation_system.model.User;
import pl.dawidwiktorowski.reservation_system.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("messageerror", "Nieprawidłowy e-mail lub hasło");
        }
        if (logout != null) {
            model.addAttribute("messagelogout", "Wylogowano pomyślnie");
        }
        return "form";
    }

    @GetMapping(value = "/register")
    public String showFormRegistration(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping(value = "/register")
    public String registrationUser(@ModelAttribute User user, @RequestParam String pemail, @RequestParam String pass, BindingResult result, Model model) {
        User u = userService.findByEmail(user.getEmail());
        if (u != null){
            model.addAttribute("email", "Ten email jest już zarejestrowany");
            return "form";
        }else if (!pemail.equals((user.getEmail()))){
            model.addAttribute("pemailError", "Emaile nie pasują");
            return "form";
        }else if (!pass.equals(user.getPassword())){
            model.addAttribute("passError", "Hasła nie pasują");
            return "form";
        }else if (result.hasErrors()){
            return "form";
        }else{
            userService.saveUser(user);
            return "redirect:/login";
        }
    }
}
