package com.anuj.movie.Converter;

import com.anuj.movie.Entities.User;
import com.anuj.movie.Request.UserRequest;
import com.anuj.movie.Responses.UserResponse;

public class UserConverter {
    public static User userDtoToUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .gender(userRequest.getGender())
                .phoneNumber(userRequest.getPhoneNumber())
                .emailId(userRequest.getEmailId())
                .roles(userRequest.getRoles())
                .build();

        return user;
    }

    public static UserResponse userToUserDto(User user) {
        UserResponse userDto = UserResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .gender(user.getGender())
                .build();

        return userDto;
    }
}
