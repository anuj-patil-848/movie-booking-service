package com.anuj.movie.Exceptions;

public class MovieAlreadyExists extends RuntimeException{

    public MovieAlreadyExists(){
        super("Movie with this name and language already exists");
    }
}
