package com.anuj.movie.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.anuj.movie.Converter.TicketConverter;
import com.anuj.movie.Entities.Show;
import com.anuj.movie.Entities.ShowSeat;
import com.anuj.movie.Entities.Ticket;
import com.anuj.movie.Entities.User;
import com.anuj.movie.Exceptions.SeatDoesNotExist;
import com.anuj.movie.Exceptions.SeatsNotAvailable;
import com.anuj.movie.Exceptions.ShowDoesNotExist;
import com.anuj.movie.Exceptions.UserDoesNotExist;
import com.anuj.movie.Repositories.ShowRepository;
import com.anuj.movie.Repositories.TicketRepository;
import com.anuj.movie.Repositories.UserRepository;
import com.anuj.movie.Request.TicketRequest;
import com.anuj.movie.Responses.TicketResponse;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    public TicketResponse ticketBooking(TicketRequest ticketRequest) throws SeatsNotAvailable, UserDoesNotExist, ShowDoesNotExist, SeatDoesNotExist{

        Optional<Show> showOpt = showRepository.findById(ticketRequest.getShowId());
		
        if(showOpt.isEmpty()){
            throw new ShowDoesNotExist();
        }

        Optional<User> userOpt = userRepository.findById(ticketRequest.getUserId());

        if(userOpt.isEmpty()){
            throw new UserDoesNotExist();
        }

        User user = userOpt.get();
        Show show = showOpt.get();

        Boolean isSeatAvailable = isSeatAvailable(show.getShowSeatList(), ticketRequest.getRequestSeats());

		if (!isSeatAvailable) {
			throw new SeatsNotAvailable();
		}

		Integer getPriceAndAssignSeats = getPriceAndAssignSeats(show.getShowSeatList(),	ticketRequest.getRequestSeats());
		String seats = listToString(ticketRequest.getRequestSeats());
		List<String> availableSeats = showRepository.findAvailableSeats(ticketRequest.getShowId());

		if(!seatsExist(ticketRequest.getRequestSeats(), availableSeats)){
			throw new SeatDoesNotExist();
		}

		Ticket ticket = new Ticket();
		ticket.setTotalTicketsPrice(getPriceAndAssignSeats);
		ticket.setBookedSeats(seats);
		ticket.setUser(user);
		ticket.setShow(show);

		ticket = ticketRepository.save(ticket);

		user.getTicketList().add(ticket);
		show.getTicketList().add(ticket);
		userRepository.save(user);
		showRepository.save(show);

		return TicketConverter.returnTicket(show, ticket);
	}

	private Boolean seatsExist(List<String> seats, List<String> availableSeats){

		String availSeats = availableSeats.toString();
		for(String s : seats){
			if(!availSeats.contains(s)){
				return false;
			}
		}
		return true;
	}

	private Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats) {
		for (ShowSeat showSeat : showSeatList) {
			String seatNo = showSeat.getSeatNo();

			if (requestSeats.contains(seatNo) && !showSeat.getIsAvailable()) {
				return false;
			}
		}

		return true;
	}

	public String getAvailableSeats(TicketRequest ticketRequest) throws ShowDoesNotExist{
		return (showRepository.findAvailableSeats(ticketRequest.getShowId())).toString();
	}

	private Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats) {
		Integer totalAmount = 0;

		for (ShowSeat showSeat : showSeatList) {
			if (requestSeats.contains(showSeat.getSeatNo())) {
				totalAmount += showSeat.getPrice();
				showSeat.setIsAvailable(Boolean.FALSE);
			}
		}

		return totalAmount;
	}

	private String listToString(List<String> requestSeats) {
		StringBuilder sb = new StringBuilder();

		for (String s : requestSeats) {
			sb.append(s).append(",");
		}

		String temp = sb.toString();
		temp = temp.substring(0, temp.length() - 1);
		return temp;
	}

}
