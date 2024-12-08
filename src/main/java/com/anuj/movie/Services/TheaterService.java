package com.anuj.movie.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.movie.Converter.TheaterConverter;
import com.anuj.movie.Entities.Theater;
import com.anuj.movie.Entities.TheaterSeat;
import com.anuj.movie.Enums.SeatType;
import com.anuj.movie.Exceptions.TheaterAlreadyExists;
import com.anuj.movie.Exceptions.TheaterDoesNotExist;
import com.anuj.movie.Repositories.TheaterRepository;
import com.anuj.movie.Request.TheaterRequest;
import com.anuj.movie.Request.TheaterSeatRequest;

@Service
public class TheaterService {
    @Autowired
	private TheaterRepository theaterRepository;

	public String addTheater(TheaterRequest theaterRequest) throws TheaterAlreadyExists {
		if (theaterRepository.findByAddress(theaterRequest.getAddress()) != null) {
			throw new TheaterAlreadyExists();
		}
		
		Theater theater = TheaterConverter.theaterToTheater(theaterRequest);

		theaterRepository.save(theater);
		return "Theater has been saved Successfully";
	}

	public String addTheaterSeat(TheaterSeatRequest entryDto) throws TheaterDoesNotExist {
		if (theaterRepository.findByAddress(entryDto.getAddress()) == null) {
			throw new TheaterDoesNotExist();
		}
		System.out.println(entryDto.getNoOfPremiumSeats());
		
		Integer noOfSeatsInRow = entryDto.getNoOfSeatsInRow();
		Integer noOfPremiumSeats = entryDto.getNoOfPremiumSeats();
		Integer noOfRegularSeats = entryDto.getNoOfRegularSeats();
		String address = entryDto.getAddress();

		Theater theater = theaterRepository.findByAddress(address);

		List<TheaterSeat> seatList = theater.getTheaterSeatList();

		int counter = 1;
		int fill = 0;
		char ch = 'A';

		for (int i = 1; i <= noOfRegularSeats; i++) {
			String seatNo = Integer.toString(counter) + ch;

			ch++;
			fill++;
			if (fill == noOfSeatsInRow) {
				fill = 0;
				counter++;
				ch = 'A';
			}

			TheaterSeat theaterSeat = new TheaterSeat();
			theaterSeat.setSeatNo(seatNo);
			theaterSeat.setSeatType(SeatType.REGULAR);
			theaterSeat.setTheater(theater);
			seatList.add(theaterSeat);
		}

		for (int i = 1; i <= noOfPremiumSeats; i++) {
			String seatNo = Integer.toString(counter) + ch;

			ch++;
			fill++;
			if (fill == noOfSeatsInRow) {
				fill = 0;
				counter++;
				ch = 'A';
			}

			TheaterSeat theaterSeat = new TheaterSeat();
			theaterSeat.setSeatNo(seatNo);
			theaterSeat.setSeatType(SeatType.PREMIUM);
			theaterSeat.setTheater(theater);
			seatList.add(theaterSeat);
		}

		theaterRepository.save(theater);

		return "Theater Seats have been added successfully";
	}
}
