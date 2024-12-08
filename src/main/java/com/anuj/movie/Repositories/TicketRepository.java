package com.anuj.movie.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anuj.movie.Entities.Ticket;


public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    @Query(value="select booked_seats from tickets where show_id = :showId and user_id = :userId", nativeQuery = true)
    public List<String> getTicketsBookedUnderUser(Integer userId, Integer showId);
}
