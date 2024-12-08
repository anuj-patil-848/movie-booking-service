package com.anuj.movie.Exceptions;

public class TheaterDoesNotExist extends RuntimeException{

    public TheaterDoesNotExist(){
        super("Theater does not exist");
    }
}
