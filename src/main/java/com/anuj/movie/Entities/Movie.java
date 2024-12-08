package com.anuj.movie.Entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.anuj.movie.Enums.Genre;
import com.anuj.movie.Enums.Language;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "MOVIES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private String movieName;

    private Integer duration;

    @Column(scale = 2)
    private Double rating;

    private Date releaseDate;
    
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    
    @Enumerated(value = EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();

}
