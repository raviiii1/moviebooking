package com.ravi.moviebooking.service;

import com.ravi.moviebooking.dto.impl.CinemaHallDto;

public interface CinemaHallService {

	CinemaHallDto put(CinemaHallDto dto);

	CinemaHallDto get(Long id);
	
}
