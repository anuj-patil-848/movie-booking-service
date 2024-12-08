package com.anuj.movie.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.movie.Request.TicketRequest;
import com.anuj.movie.Responses.TicketResponse;
import com.anuj.movie.Services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<Object> ticketBooking(@RequestBody TicketRequest ticketRequest){
        try{
            TicketResponse result = ticketService.ticketBooking(ticketRequest);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/getAvailableSeats")
    public ResponseEntity<String> getAvailableSeatsForShow(@RequestBody TicketRequest ticketRequest){
        try{
            String result = ticketService.getAvailableSeats(ticketRequest);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
