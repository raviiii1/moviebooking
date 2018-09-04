package com.ravi.moviebooking.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.CinemaHallDto;
import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.model.impl.Show;
import com.ravi.moviebooking.repository.ShowRepository;
import com.ravi.moviebooking.service.CinemaHallService;
import com.ravi.moviebooking.service.MovieService;
import com.ravi.moviebooking.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowRepository repository;

	@Autowired
	ShowConverter showConverter;

	@Autowired
	CinemaHallService cinemaHallService;

	@Autowired
	MovieService movieService;

	@Override
	public ShowDto putShow(ShowDto dto) {
		dto.setId(null);
		dto.setBooked(null);
		CinemaHallDto cinemaHallDto = cinemaHallService.getCinemaHall(dto.getCinemaHallId());
		if (cinemaHallDto != null)
			dto.setAllAvailable(cinemaHallDto.getRowCount(), cinemaHallDto.getColumnCount());
		return showConverter.convertToDto(repository.save(showConverter.convertToBo(dto)));
	}
	
	@Override
	public ShowDto updateShow(ShowDto dto) {
		return showConverter.convertToDto(repository.save(showConverter.convertToBo(dto)));
	}

	@Override
	public ShowDto getShow(Long showId) {
		Show show = repository.findById(showId).get();
		if (show == null)
			return null;
		return showConverter.convertToDto(show);
	}

	@Override
	public List<ShowDto> getMovieShows(Long movieId) {
		LocalDateTime now = LocalDateTime.now();
		List<Show> movieShows = repository.findAllByMovieIdAndCreatedAtBetween(movieId, now, now.plusDays(7));
		return movieShows.parallelStream().map(show -> showConverter.convertToDto(show)).collect(Collectors.toList());
	}

	@Override
	public List<ShowDto> searchShows(LocalDate date, LocalTime time) {
		List<Show> movieShows = repository.findAllByDateAndTime(date, time);
		return movieShows.parallelStream().map(show -> showConverter.convertToDto(show)).collect(Collectors.toList());
	}

	@Override
	public List<ShowDto> searchShows(LocalTime time) {
		List<Show> movieShows = repository.findAllByTime(time);
		return movieShows.parallelStream().map(show -> showConverter.convertToDto(show)).collect(Collectors.toList());
	}

	@Override
	public List<ShowDto> searchShows(LocalDate date) {
		List<Show> movieShows = repository.findAllByDate(date);
		return movieShows.parallelStream().map(show -> showConverter.convertToDto(show)).collect(Collectors.toList());
	}

	@Override
	public List<ShowDto> getAllShows() {
		List<Show> movieShows = repository.findAll();
		return movieShows.parallelStream().map(show -> showConverter.convertToDto(show)).collect(Collectors.toList());
	}
}
