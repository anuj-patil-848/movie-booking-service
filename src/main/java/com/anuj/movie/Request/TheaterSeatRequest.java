package com.anuj.movie.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TheaterSeatRequest {
    @JsonProperty("address")
    private String address;

    @JsonProperty("noOfSeatsInRow")
    private Integer noOfSeatsInRow;

    @JsonProperty("noOfPremiumSeats")
    private Integer noOfPremiumSeats;

    @JsonProperty("noOfRegularSeats")
    private Integer noOfRegularSeats;
}
