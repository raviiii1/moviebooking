package com.ravi.moviebooking.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ravi.moviebooking.model.impl.Show;

public interface ShowService {

	Show put(Show show);

	Show update(Show show);

	Show get(Long showId);

	List<Show> getAll();

	List<Show> getRunningByMovieId(Long movieId);
	
	List<Show> getAllRunning();

	List<Show> getByDate(LocalDate date);

	List<Show> getByDateAndTime(LocalDate date, LocalTime time);

	List<Show> getByTime(LocalTime time);
	
}
