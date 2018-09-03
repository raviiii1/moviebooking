package com.ravi.moviebooking.service;

import java.util.List;

import com.ravi.moviebooking.dto.impl.MovieDto;

public interface MovieService {

	List<MovieDto> getAllActiveMovies();

	MovieDto getMovie(Long id);

	List<MovieDto> getMovies(List<Long> movieIds);
	
}
