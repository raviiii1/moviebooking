package com.ravi.moviebooking.service;

import com.ravi.moviebooking.dto.impl.CinemaHallDto;

public interface CinemaHallService {

	CinemaHallDto putCinemaHall(CinemaHallDto dto);

	CinemaHallDto getCinemaHall(Long id);
	
}
