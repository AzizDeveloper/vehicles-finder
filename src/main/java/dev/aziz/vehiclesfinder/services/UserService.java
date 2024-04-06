package dev.aziz.vehiclesfinder.services;

import dev.aziz.vehiclesfinder.entities.User;
import dev.aziz.vehiclesfinder.exceptions.AppException;
import dev.aziz.vehiclesfinder.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByLogin(String login) {
        User user = userRepository.findUserByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return user;
    }
}
