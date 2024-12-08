package com.anuj.movie.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.movie.Converter.ShowConverter;
import com.anuj.movie.Entities.Movie;
import com.anuj.movie.Entities.Show;
import com.anuj.movie.Entities.ShowSeat;
import com.anuj.movie.Entities.Theater;
import com.anuj.movie.Entities.TheaterSeat;
import com.anuj.movie.Enums.SeatType;
import com.anuj.movie.Exceptions.MovieDoesNotExist;
import com.anuj.movie.Exceptions.ShowDoesNotExist;
import com.anuj.movie.Exceptions.TheaterDoesNotExist;
import com.anuj.movie.Repositories.MovieRepository;
import com.anuj.movie.Repositories.ShowRepository;
import com.anuj.movie.Repositories.TheaterRepository;
import com.anuj.movie.Request.ShowRequest;
import com.anuj.movie.Request.ShowSeatRequest;

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addShow(ShowRequest showRequest) throws MovieDoesNotExist, TheaterDoesNotExist{
        Show show = ShowConverter.showToShow(showRequest);

        Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());

        if(movieOpt.isEmpty()){
            throw new MovieDoesNotExist();
        }

        Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());

        if(theaterOpt.isEmpty()){
            throw new TheaterDoesNotExist();
        } 

        Theater theater = theaterOpt.get();
        Movie movie = movieOpt.get();

        System.out.println(movie.getMovieName());
        System.out.println(theater.getName());

        show.setMovie(movie);
        show.setTheater(theater);
        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show has been successfully added";
    }

    public String associateShowSeats(ShowSeatRequest showSeatRequest) throws ShowDoesNotExist{
        Optional<Show> showOpt = showRepository.findById(showSeatRequest.getShowId());

        if(showOpt.isEmpty()){
            throw new ShowDoesNotExist();
        }

        Show show = showOpt.get();
        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.REGULAR)){
                showSeat.setPrice(showSeatRequest.getPriceOfRegularSeat());
            } else{
                showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
            }

            showSeat.setShow(show);
            showSeat.setIsAvailable(Boolean.TRUE);
            showSeat.setIsFoodContained(Boolean.FALSE);

            showSeatList.add(showSeat);
        }

        showRepository.save(show);

        return "Show seats have been associated successfully";
    }

}
