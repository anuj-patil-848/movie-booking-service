package com.anuj.movie.Converter;

import com.anuj.movie.Entities.Show;
import com.anuj.movie.Request.ShowRequest;

public class ShowConverter {

    public static Show showToShow(ShowRequest showRequest){
        Show show = Show.builder()
                .time(showRequest.getShowStartTime())
                .date(showRequest.getShowDate())
                .build();

        return show;
    }
}
