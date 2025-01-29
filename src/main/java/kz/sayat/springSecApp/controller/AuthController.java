package kz.sayat.springSecApp.controller;

import kz.sayat.springSecApp.models.Person;
import kz.sayat.springSecApp.repo.PeopleRepository;
import kz.sayat.springSecApp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PeopleService peopleService;

    @Autowired
    public AuthController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registerPage(@ModelAttribute("person") Person person) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") Person person) {

        peopleService.register(person);
        return "redirect:/auth/login";
    }


}
