package com.anuj.movie.Entities;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityScan
@Table(name = "shows")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Time time;
    
    private Date date;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList = new ArrayList<>();
    
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();
}
