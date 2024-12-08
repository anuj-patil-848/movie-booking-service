package com.anuj.movie.Exceptions;

public class SeatsNotAvailable extends RuntimeException{

    public SeatsNotAvailable(){
        super("Seat(s) not available");
    }

}
