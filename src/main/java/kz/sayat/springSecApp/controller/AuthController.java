package kz.sayat.springSecApp.controller;

import jakarta.servlet.http.HttpSession;
import kz.sayat.springSecApp.models.Person;
import kz.sayat.springSecApp.service.PeopleService;
import kz.sayat.springSecApp.dto.AuthRequest;
import kz.sayat.springSecApp.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")  // Разрешаем запросы с React (3000 порт)
public class AuthController {

    private final PeopleService peopleService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(PeopleService peopleService, AuthenticationManager authenticationManager) {
        this.peopleService = peopleService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(new AuthResponse("Успешная аутентификация"));
        } else {
            return ResponseEntity.status(401).body(new AuthResponse("Ошибка аутентификации"));
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody Person person) {
        peopleService.register(person);
        return ResponseEntity.ok("Регистрация успешна");
    }

    @GetMapping("/me")
    public ResponseEntity<Person> me(HttpSession session) {
        Person user = (Person) session.getAttribute("user"); // Получаем пользователя из сессии

        if (user == null) {
            return ResponseEntity.status(401).build(); // Если нет пользователя, 401 Unauthorized
        }

        return ResponseEntity.ok(user); // Возвращаем данные пользователя
    }

}
