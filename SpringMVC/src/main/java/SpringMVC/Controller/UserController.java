package SpringMVC.Controller;

import SpringMVC.Entity.Companies;
import SpringMVC.Entity.Gender;
import SpringMVC.Entity.User;
import SpringMVC.Service.CompanyService;
import SpringMVC.Service.GenderService;
import SpringMVC.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService ;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private GenderService genderService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("genders", genderService.getAllGenders());
        model.addAttribute("companies", companyService.getAll());
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email , @RequestParam String password, Model model) {
        if (userService.login(email, password)) {
            return "redirect:/home";
        }
        return "redirect:/login";
    }
}

