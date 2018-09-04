package com.ravi.moviebooking.dto.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ravi.moviebooking.dto.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDto implements Dto{

	private Long id;
	private String name;
	
	@JsonProperty("running_time_minutes")
	private Integer runningTimeInMinutes;
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	
	public void isActive(boolean active) {
		this.active = active;
	}
}
