package dev.aziz.vehiclesfinder.services;

import dev.aziz.vehiclesfinder.dtos.CredentialsDto;
import dev.aziz.vehiclesfinder.dtos.UserDto;
import dev.aziz.vehiclesfinder.entities.User;
import dev.aziz.vehiclesfinder.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto authenticate(CredentialsDto credentialsDto) {
        User byLogin = findByLogin(credentialsDto.getLogin());
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), byLogin.getPassword())) {
            return userMapper.userToUserDto(byLogin);
        }
        throw new RuntimeException("Invalid password");
    }

    public User findByLogin(String login) {
        return userService.findByLogin(login);
    }
}
