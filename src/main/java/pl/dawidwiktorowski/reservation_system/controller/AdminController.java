package pl.dawidwiktorowski.reservation_system.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dawidwiktorowski.reservation_system.model.Category;
import pl.dawidwiktorowski.reservation_system.model.SubCategory;
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

    @PreAuthorize(value = "isAuthenticated() and hasRole('ADMIN')")
    @GetMapping(value = "/main")
    public String showAdminPanel(Model model) {
        List<Category> categories = categoryServiceInterface.findAll();
        model.addAttribute("categories", categories);
        return "admin/homePage";
    }

    @GetMapping(value = "/addCategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/addCategory";
    }

    @PostMapping(value = "/addCategory")
    public String addCategory(@ModelAttribute Category category) {
        categoryServiceInterface.add(category);
        return "redirect:/admin/main";
    }

    @GetMapping(value = "/addSubCategory")
    public String showAddSubcategoryForm(Model model) {
        List<Category> categories = categoryServiceInterface.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("subcategory", new SubCategory());
        return "admin/addSubcategory";
    }

    @PostMapping(value = "/addSubCategory")
    public String addSubCategory(@ModelAttribute SubCategory subCategory) {
        subCategoryServiceInterface.add(subCategory);
        return "redirect:/admin/main";
    }

    @GetMapping(value = "/reservation")
    public String showReservation(Model model) {
        model.addAttribute("reservations", reservationServiceInterface.showAllReservationWithStatusFalse());
        return "admin/reservationListForm";
    }

    @GetMapping(value = "/reservation/{reservationId}")
    public String confirmReservation(@PathVariable("reservationId") Long id) {
        reservationServiceInterface.confirmReservation(id);
        return "redirect:/admin/reservation";
    }

}
