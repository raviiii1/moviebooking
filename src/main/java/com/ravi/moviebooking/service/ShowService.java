package com.ravi.moviebooking.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ravi.moviebooking.dto.impl.ShowDto;

public interface ShowService {

	ShowDto getShow(Long showId);

	ShowDto putShow(ShowDto show);

	List<ShowDto> getMovieShows(Long movieId);

	List<ShowDto> searchShows(LocalDate date, LocalTime time);

	List<ShowDto> searchShows(LocalTime time);

	List<ShowDto> searchShows(LocalDate date);

	List<ShowDto> getAllShows();

	ShowDto updateShow(ShowDto dto);
		
}
