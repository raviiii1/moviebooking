package com.ravi.moviebooking.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.moviebooking.dto.impl.MovieDto;
import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.service.MovieService;
import com.ravi.moviebooking.service.ShowService;

@Controller
@RequestMapping(path = "/search")
public class SearchController {

	@Autowired
	ShowService showService;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping(path = "")
	@ResponseBody
	public List<ShowDto> searchShows(@RequestParam(name = "date", required = false) LocalDate date,
			@RequestParam(name = "time", required = false) LocalTime time,
			@RequestParam(name = "movie", required = false) String movieName) {
		
		if (date == null && time == null && movieName == null)
			return null;
		
		List<ShowDto> shows;
		if(date != null && time != null)
			shows = showService.searchShows(date, time);
		else if(date == null && time != null)
			shows = showService.searchShows(time);
		else if(time == null && date != null)
			shows = showService.searchShows(date);
		else
			shows = showService.getAllShows();
		
		List<Long> movieIds = shows.parallelStream().map(show -> show.getMovieId()).collect(Collectors.toList());
		List<MovieDto> movies = movieService.getMovies(movieIds);
		List<Long> filteredMoviesid = movies.parallelStream().filter(movie -> movie.getName().contains(movieName) || movieName.contains(movie.getName())).map(movie -> movie.getId()).collect(Collectors.toList());
		return shows.parallelStream().filter(show -> filteredMoviesid.contains(show.getMovieId())).collect(Collectors.toList());	
	}

}
