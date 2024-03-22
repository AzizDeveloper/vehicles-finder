package dev.aziz.vehiclesfinder.controllers;

import dev.aziz.vehiclesfinder.configs.UserAuthenticationProvider;
import dev.aziz.vehiclesfinder.dtos.CredentialsDto;
import dev.aziz.vehiclesfinder.dtos.SignUpDto;
import dev.aziz.vehiclesfinder.dtos.UserDto;
import dev.aziz.vehiclesfinder.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(CredentialsDto user) {
        UserDto login = userService.login(user);
        return ResponseEntity.ok(login);
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserDto> signUp(@RequestBody @Valid SignUpDto signUpDto) {
        UserDto createdUser = userService.signUp(signUpDto);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId() + "/profile")).body(createdUser);
    }

    @PostMapping("/signOut")
    public ResponseEntity<Void> signOut(@AuthenticationPrincipal UserDto user) {
        SecurityContextHolder.clearContext();
        return ResponseEntity.noContent().build();
    }

}
