package com.anuj.movie.Exceptions;

public class MovieDoesNotExist extends RuntimeException{

    public MovieDoesNotExist(){
        super("Movie with this name and language does not exist");
    }
}
