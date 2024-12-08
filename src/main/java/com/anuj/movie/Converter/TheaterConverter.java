package com.anuj.movie.Converter;

import com.anuj.movie.Entities.Theater;
import com.anuj.movie.Request.TheaterRequest;

public class TheaterConverter {
public static Theater theaterToTheater(TheaterRequest theaterRequest) {
        Theater theater = Theater.builder()
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();
        return theater;
    }
}
