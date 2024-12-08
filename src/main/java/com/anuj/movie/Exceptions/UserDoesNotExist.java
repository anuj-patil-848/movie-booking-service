package com.anuj.movie.Exceptions;

public class UserDoesNotExist extends RuntimeException{
    
    public UserDoesNotExist(){
        super("Movie with this name and language does not exist");
    }
}
