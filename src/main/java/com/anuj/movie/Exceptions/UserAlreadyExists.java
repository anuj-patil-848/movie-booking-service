package com.anuj.movie.Exceptions;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(){
        super("User Already Exists");
    }
}
