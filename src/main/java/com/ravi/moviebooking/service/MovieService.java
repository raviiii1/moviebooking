package com.ravi.moviebooking.service;

import java.util.List;

import com.ravi.moviebooking.dto.impl.MovieDto;

public interface MovieService {

	List<MovieDto> getAllActive();

	MovieDto get(Long id);

	List<MovieDto> getAll(List<Long> movieIds);

	MovieDto put(MovieDto movieDto);

	boolean delete(Long id);
	
}
