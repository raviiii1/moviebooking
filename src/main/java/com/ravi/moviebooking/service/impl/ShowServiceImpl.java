package com.ravi.moviebooking.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.model.impl.Show;
import com.ravi.moviebooking.repository.jpa.ShowRepository;
import com.ravi.moviebooking.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

	private static final long SHOW_RUNNING_TIME = 7;

	@Autowired
	ShowRepository repository;

	@Override
	public Show put(Show show) {
		show.setId(null);
		show.setBooked(null);
		return repository.save(show);
	}

	@Override
	public Show update(Show show) {
		return repository.save(show);
	}

	@Override
	public Show get(Long showId) {
		return repository.findById(showId).get();
	}

	@Override
	public List<Show> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Show> getRunningByMovieId(Long movieId) {
		LocalDateTime now = LocalDateTime.now();
		return repository.findAllByMovieIdAndCreatedAtBetween(movieId, now, now.plusDays(SHOW_RUNNING_TIME));
	}

	@Override
	public List<Show> getAllRunning() {
		LocalDateTime now = LocalDateTime.now();
		return repository.findAllByCreatedAtBetween(now, now.plusDays(SHOW_RUNNING_TIME));
	}
	
	@Override
	public List<Show> getByDate(LocalDate date) {
		return repository.findAllByDate(date);
	}

	@Override
	public List<Show> getByDateAndTime(LocalDate date, LocalTime time) {
		return repository.findAllByDateAndTime(date, time);
	}

	@Override
	public List<Show> getByTime(LocalTime time) {
		return repository.findAllByTime(time);
	}

}
