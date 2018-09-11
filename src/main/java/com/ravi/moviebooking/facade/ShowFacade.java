package com.ravi.moviebooking.facade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ravi.moviebooking.dto.impl.ShowDto;

public interface ShowFacade {
	
	ShowDto put(ShowDto dto);
	
	ShowDto get(Long id);

	List<ShowDto> search(LocalDate date, LocalTime time, String movieName);
	
	List<ShowDto> getRunning(Long movieId);
	
	List<ShowDto> getAllRunning();

}
