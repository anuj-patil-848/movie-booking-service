package com.anuj.movie.Converter;

import com.anuj.movie.Entities.Movie;
import com.anuj.movie.Request.MovieRequest;

public class MovieConverter {
    public static Movie movieToMovie(MovieRequest movieRequest){
        Movie movie = Movie.builder()
                    .movieName(movieRequest.getMovieName())
                    .duration(movieRequest.getDuration())
                    .genre(movieRequest.getGenre())
                    .language(movieRequest.getLanguage())
                    .releaseDate(movieRequest.getReleaseDate())
                    .rating(movieRequest.getRating())
                    .build();
        
        return movie;
    }
}
