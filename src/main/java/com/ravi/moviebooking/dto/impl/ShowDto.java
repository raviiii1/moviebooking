package com.ravi.moviebooking.dto.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ravi.moviebooking.dto.Dto;
import com.ravi.moviebooking.model.impl.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ShowDto implements Dto{

	Long id;
	
	LocalTime time;
	LocalDate date;
	
	@JsonProperty("cinema_hall_id")
	Long cinemaHallId;
	
	@JsonProperty("movie_id")
	Long movieId;
	
	@JsonProperty("price_per_seat")
	Double pricePerSeat;
	
	private List<Seat> booked;
	private List<Seat> available;
	
	public void setAllAvailable(Integer rowCount, Integer columnCount) {
		available = setAllSeats(rowCount, columnCount);
	}

	public void setAllBooked(Integer rowCount, Integer columnCount) {
		booked = setAllSeats(rowCount, columnCount);
	}
	
	private List<Seat> setAllSeats(Integer rowCount, Integer columnCount) {
		List<Seat> seats = new ArrayList<>();
		for(int i = 0; i< rowCount;i++) {
			for(int j=0; j<columnCount; j++) {
				seats.add(new Seat(i, j));
			}
		}
		return seats;
	}
}
