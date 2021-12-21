package pl.dawidwiktorowski.reservation_system.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidwiktorowski.reservation_system.model.Category;
import pl.dawidwiktorowski.reservation_system.service.CategoryServiceInterface;
import pl.dawidwiktorowski.reservation_system.service.ReservationServiceInterface;
import pl.dawidwiktorowski.reservation_system.service.SubCategoryServiceInterface;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {

    private final CategoryServiceInterface categoryServiceInterface;

    private final SubCategoryServiceInterface subCategoryServiceInterface;

    private final ReservationServiceInterface reservationServiceInterface;

    @PreAuthorize("isAuthenticated() and hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/main")
    public String showAdminPanel(Model model){
        List<Category> categories = categoryServiceInterface.findAll();
        model.addAttribute("categories", categories);
        return "admin/homePage";
    }

    @GetMapping(value = "/addCategory")
    public String showAddCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "admin/addcategory";
    }

}
