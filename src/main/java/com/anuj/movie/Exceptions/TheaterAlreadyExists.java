package com.anuj.movie.Exceptions;

public class TheaterAlreadyExists extends RuntimeException{

    public TheaterAlreadyExists(){
        super("Theater with this name and address already exists");
    }
}
