package com.anuj.movie.Converter;

import com.anuj.movie.Entities.Show;
import com.anuj.movie.Entities.Ticket;
import com.anuj.movie.Responses.TicketResponse;

public class TicketConverter {
    public static TicketResponse returnTicket(Show show, Ticket ticket) {
        TicketResponse ticketResponseDto = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .time(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}
