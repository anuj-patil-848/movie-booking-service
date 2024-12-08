package com.anuj.movie.Entities;
import java.util.ArrayList;
import java.util.List;

import com.anuj.movie.Enums.Gender;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    @Column(unique = true, nullable=false)
    private String emailId;

    private String roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

}
