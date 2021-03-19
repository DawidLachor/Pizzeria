package dev.dawidlachor.pizzeria.rest;

import dev.dawidlachor.pizzeria.dto.RegisterRequestDto;
import dev.dawidlachor.pizzeria.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequestDto registerRequest){
        userService.signup(registerRequest);
        return new ResponseEntity<>("User Registration successful", HttpStatus.OK);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verification(@PathVariable String token){
        userService.verification(token);
        return new ResponseEntity<>("User verification successful", HttpStatus.OK);
    }

}
