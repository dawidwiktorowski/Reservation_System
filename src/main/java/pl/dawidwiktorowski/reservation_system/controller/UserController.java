package pl.dawidwiktorowski.reservation_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dawidwiktorowski.reservation_system.model.Category;
import pl.dawidwiktorowski.reservation_system.model.User;
import pl.dawidwiktorowski.reservation_system.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String showRolePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        if (user == null || user.getRole().getRoleType().equals("ROLE_USER")) {
            model.addAttribute("user", user);
            return "index";
        } else if (user.getRole().getRoleType().equals("ROLE_ADMIN")) {
            return "index";
        }
        return null;
    }


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
        return "loginForm";
    }

    @GetMapping(value = "/register")
    public String showFormRegistration(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String registrationUser(@ModelAttribute User user, @RequestParam String pemail, @RequestParam String confirmPassword, BindingResult result, Model model) {
        User u = userService.findByEmail(user.getEmail());
        if (u != null) {
            model.addAttribute("email", "Ten email jest już zarejestrowany");
            return "register";
        } else if (!pemail.equals((user.getEmail()))) {
            model.addAttribute("pemailError", "Emaile nie pasują");
            return "register";
        } else if (!confirmPassword.equals(user.getPassword())) {
            model.addAttribute("passError", "Hasła nie pasują");
            return "register";
        } else if (result.hasErrors()) {
            return "register";
        } else {
            userService.saveUser(user);
            return "redirect:/login";
        }
    }
}
