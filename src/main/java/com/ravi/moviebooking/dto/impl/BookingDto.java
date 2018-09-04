package com.ravi.moviebooking.dto.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ravi.moviebooking.dto.Dto;
import com.ravi.moviebooking.model.impl.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDto implements Dto{

	private Long id;

	@JsonProperty("user_id")
	private Long userId;

	@JsonProperty("show_id")
	private Long showId;

	private List<Seat> seats;
	private double price;

}
