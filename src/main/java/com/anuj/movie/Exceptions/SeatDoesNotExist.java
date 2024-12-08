package com.anuj.movie.Exceptions;

public class SeatDoesNotExist extends RuntimeException{
    public  SeatDoesNotExist(){
        super("The Selected Seats Do Not Exist");
    }
}
