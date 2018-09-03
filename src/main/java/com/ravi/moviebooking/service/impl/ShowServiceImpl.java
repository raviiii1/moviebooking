package com.ravi.moviebooking.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.SeatMatrixDto;
import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.model.impl.Show;
import com.ravi.moviebooking.repository.ShowRepository;
import com.ravi.moviebooking.service.MovieService;
import com.ravi.moviebooking.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowRepository repository;

	@Autowired
	ShowConverter showConverter;

	@Autowired
	SeatMatrixConverter matrixConverter;

	@Autowired
	MovieService movieService;
	
	@Override
	public ShowDto putShow(ShowDto dto) {
		dto.setId(null);
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
	public SeatMatrixDto getShowSeatMatrix(Long showId) {

		SeatMatrixDto matrix = null;
		Show show = repository.findById(showId).get();

		if (show != null)
			matrix = matrixConverter.convertToDto(show.getSeatMatrix());

		return matrix;
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
