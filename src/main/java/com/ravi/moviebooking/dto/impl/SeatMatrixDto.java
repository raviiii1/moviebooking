package com.ravi.moviebooking.dto.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ravi.moviebooking.dto.Dto;
import com.ravi.moviebooking.model.impl.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class SeatMatrixDto implements Dto{
	
	private Long id;
	private Long showId;
	private List<Seat> booked;
	private List<Seat> available;

}
