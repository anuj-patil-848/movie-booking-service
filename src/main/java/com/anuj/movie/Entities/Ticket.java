package com.anuj.movie.Entities;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TICKETS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    
    private Integer totalTicketsPrice;
    
    private String bookedSeats;

    @CreationTimestamp
    private Time bookedAtTime;

    @CreationTimestamp
    private Date bookedAtDate;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private User user;

}
