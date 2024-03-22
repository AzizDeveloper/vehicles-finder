package dev.aziz.vehiclesfinder.services;

import dev.aziz.vehiclesfinder.dtos.CredentialsDto;
import dev.aziz.vehiclesfinder.dtos.SignUpDto;
import dev.aziz.vehiclesfinder.dtos.UserDto;
import dev.aziz.vehiclesfinder.entities.User;
import dev.aziz.vehiclesfinder.exceptions.AppException;
import dev.aziz.vehiclesfinder.mappers.UserMapper;
import dev.aziz.vehiclesfinder.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public UserDto signUp(SignUpDto signUpDto) {
        User user = userMapper.signUpDtoToUser(signUpDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.getPassword())));
        User saved = userRepository.save(user);
        return userMapper.userToUserDto(saved);
    }

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findUserByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.userToUserDto(user);
        }

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public User findByLogin(String login) {
        User user = userRepository.findUserByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return user;
    }
}
