package com.anuj.movie.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.movie.Converter.MovieConverter;
import com.anuj.movie.Entities.Movie;
import com.anuj.movie.Exceptions.MovieAlreadyExists;
import com.anuj.movie.Request.MovieRequest;
import com.anuj.movie.Repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest) throws MovieAlreadyExists{
        Movie movieByName = movieRepository.findByMovieName(movieRequest.getMovieName());

        if(movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())){
            throw new MovieAlreadyExists();
        }

        Movie movie = MovieConverter.movieToMovie(movieRequest);

        movieRepository.save(movie);
        return "This movie has been saved successfully";
    }

}
