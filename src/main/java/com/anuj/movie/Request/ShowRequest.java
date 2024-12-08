package com.anuj.movie.Request;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ShowRequest {
    @JsonProperty("showStartTime")
    private Time showStartTime;

    @JsonProperty("showDate")
    private Date showDate;

    @JsonProperty("theaterId")
    private Integer theaterId;

    @JsonProperty("movieId")
    private Integer movieId;
}
