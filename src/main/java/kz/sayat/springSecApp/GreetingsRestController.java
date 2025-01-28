//package kz.sayat.springSecApp;
//
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//import java.util.Map;
//
//@RestController
//public class GreetingsRestController {
//    @GetMapping("api/v1/greetings")
//    public ResponseEntity<Map<String, String >> greetings() {
//
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
//            .getAuthentication().getPrincipal();
//        return ResponseEntity.ok()
//            .contentType(MediaType.APPLICATION_JSON)
//            .body(Map.of("greeting", "Hello, %s!"
//                .formatted(userDetails.getUsername())));
//    }
//
//
//    @GetMapping("api/v2/greetings")
//    public ResponseEntity<Map<String, String >> greetingsV2(HttpServletRequest request) {
//
//        UserDetails userDetails = (UserDetails) ((Authentication)request.getUserPrincipal())
//            .getPrincipal();
//        return ResponseEntity.ok()
//            .contentType(MediaType.APPLICATION_JSON)
//            .body(Map.of("greeting", "Hello, %s!"
//                .formatted(userDetails.getUsername())));
//    }
//
//    @GetMapping("api/v3/greetings")
//    public ResponseEntity<Map<String, String >> greetingsV3(@AuthenticationPrincipal UserDetails userDetails) {
//        return ResponseEntity.ok()
//            .contentType(MediaType.APPLICATION_JSON)
//            .body(Map.of("greeting", "Hello, %s!"
//                .formatted(userDetails.getUsername())));
//    }
//
//
//    @GetMapping("api/v4/greetings")
//    public ResponseEntity<Map<String, String >> greetingsV3( Principal principal) {
//        return ResponseEntity.ok()
//            .contentType(MediaType.APPLICATION_JSON)
//            .body(Map.of("greeting", "Hello, %s!"
//                .formatted(principal.getName())));
//    }
//
//
//
//}
