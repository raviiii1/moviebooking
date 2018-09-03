package com.ravi.moviebooking.dto.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ravi.moviebooking.dto.Dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CinemaHallDto implements Dto{

	private Long id;	
	@JsonProperty("seat_count")
	private Integer seatCount;
	
	@JsonProperty("row_count")
	private Integer rowCount;
	
	@JsonProperty("column_count")
	private Integer columnCount;

}
