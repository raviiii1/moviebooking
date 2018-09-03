package com.ravi.moviebooking.dto.impl;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ravi.moviebooking.dto.Dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ShowDto implements Dto{

	Long id;
	LocalTime time;
	LocalDate date;
	
	@JsonProperty("cinema_hall")
	CinemaHallDto cinemaHallDto;
	
	@JsonProperty("movie_id")
	Long movieId;
	
	@JsonProperty("price_per_seat")
	Double pricePerSeat;
	
	SeatMatrixDto matrix;
}
