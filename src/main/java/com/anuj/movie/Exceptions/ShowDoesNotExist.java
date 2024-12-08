package com.anuj.movie.Exceptions;

public class ShowDoesNotExist extends RuntimeException{

    public ShowDoesNotExist(){
        super("Movie with this name and language does not exist");
    }
}
