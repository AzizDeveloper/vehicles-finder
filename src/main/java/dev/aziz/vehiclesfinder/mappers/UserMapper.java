package dev.aziz.vehiclesfinder.mappers;

import dev.aziz.vehiclesfinder.dtos.SignUpDto;
import dev.aziz.vehiclesfinder.dtos.UserDto;
import dev.aziz.vehiclesfinder.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    User signUpDtoToUser(SignUpDto signUpDto);

    UserDto userToUserDto(User user);

}
