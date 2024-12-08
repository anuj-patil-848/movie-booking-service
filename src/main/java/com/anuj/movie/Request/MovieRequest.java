package com.anuj.movie.Request;

import com.anuj.movie.Enums.Language;

import java.sql.Date;

import com.anuj.movie.Enums.Genre;

import lombok.Data;

@Data
public class MovieRequest {
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
