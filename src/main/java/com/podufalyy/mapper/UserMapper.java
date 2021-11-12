package com.podufalyy.mapper;

import com.podufalyy.domain.User;
import com.podufalyy.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {

    @Override
    public UserDto mapObjectToDto(User entity) {
        if (entity == null)
            return null;

        UserDto.UserDtoBuilder userDto = UserDto.builder();
        userDto.id(entity.getId());
        userDto.firstName(entity.getFirstName());
        userDto.lastName(entity.getLastName());
        userDto.email(entity.getEmail());
        userDto.password(entity.getPassword());
        userDto.passportId(entity.getPassportId());

        return userDto.build();
    }
}