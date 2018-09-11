package com.ravi.moviebooking.facade.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.ravi.moviebooking.dto.impl.CinemaHallDto;
import com.ravi.moviebooking.dto.impl.MovieDto;
import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.facade.ShowFacade;
import com.ravi.moviebooking.model.impl.Show;
import com.ravi.moviebooking.service.CinemaHallService;
import com.ravi.moviebooking.service.MovieService;
import com.ravi.moviebooking.service.ShowService;
import com.ravi.moviebooking.service.converter.impl.ShowConverter;

public class ShowFacadeImpl implements ShowFacade {

	@Autowired
	ShowService showService;

	@Autowired
	ShowConverter showConverter;

	@Autowired
	CinemaHallService cinemaHallService;

	@Autowired
	MovieService movieService;

	@Override
	public ShowDto get(Long id) {
		return showConverter.convertToDto(showService.get(id));
	}

	@Override
	public ShowDto put(ShowDto dto) {
		CinemaHallDto cinemaHallDto = cinemaHallService.get(dto.getCinemaHallId());
		if (cinemaHallDto != null)
			dto.setAllAvailable(cinemaHallDto.getRowCount(), cinemaHallDto.getColumnCount());
		else
			throw new IllegalArgumentException("Show must have a cinema hall id.");
		
		return showConverter.convertToDto(showService.put(showConverter.convertToBo(dto)));
	}

	@Override
	public List<ShowDto> getRunning(Long movieId) {
		List<Show> movieShows = showService.getRunningByMovieId(movieId);
		return movieShows.parallelStream().map(show -> showConverter.convertToDto(show)).collect(Collectors.toList());
	}

	
	@Override
	public List<ShowDto> getAllRunning() {
		List<Show> movieShows = showService.getAllRunning();
		return movieShows.parallelStream().map(show -> showConverter.convertToDto(show)).collect(Collectors.toList());
	}
	
	@Override
	public List<ShowDto> search(LocalDate date, LocalTime time, String movieName) {

		if (date == null && time == null && movieName == null)
			return null;

		List<Show> shows;
		if (date != null && time != null)
			shows = showService.getByDateAndTime(date, time);
		else if (date == null && time != null)
			shows = showService.getByTime(time);
		else if (time == null && date != null)
			shows = showService.getByDate(date);
		else
			shows = showService.getAll();

		List<Show> filteredShows = filterOnMovieName(movieName, shows);

		return filteredShows
				.parallelStream()
				.map(sh -> showConverter.convertToDto(sh))
				.collect(Collectors.toList());
	}

	private List<Show> filterOnMovieName(String movieName, List<Show> shows) {
		if (movieName != null) {
			List<Long> movieIds = shows.parallelStream().map(show -> show.getMovieId()).collect(Collectors.toList());
			List<MovieDto> movies = movieService.getAll(movieIds);
			List<Long> filteredMoviesid = movies.parallelStream()
					.filter(movie -> movie.getName().contains(movieName) || movieName.contains(movie.getName()))
					.map(movie -> movie.getId()).collect(Collectors.toList());
			return shows.parallelStream().filter(show -> filteredMoviesid.contains(show.getMovieId()))
					.collect(Collectors.toList());
		}
		return shows;
	}
}
