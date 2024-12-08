package com.anuj.movie.Responses;

import com.anuj.movie.Enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String name;
    private Integer age;
    private Gender gender;
    private String address;
}

