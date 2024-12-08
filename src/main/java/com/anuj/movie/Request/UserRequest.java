package com.anuj.movie.Request;

import com.anuj.movie.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("address")
    private String address;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("phoneNumber")
    private String phoneNumber; 

    @JsonProperty("roles")
    private String roles;
}
