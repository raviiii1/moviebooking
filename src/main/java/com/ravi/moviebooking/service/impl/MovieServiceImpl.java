package com.ravi.moviebooking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.MovieDto;
import com.ravi.moviebooking.model.impl.Movie;
import com.ravi.moviebooking.repository.MovieRepository;
import com.ravi.moviebooking.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository repository;

	@Autowired
	MovieConverter converter;

	@Override
	public List<MovieDto> getAllActiveMovies() {
		List<Movie> activeMovies = repository.findAllByActive(true);
		return activeMovies.parallelStream().map(mov -> converter.convertToDto(mov)).collect(Collectors.toList());
	}

	@Override
	public MovieDto getMovie(Long id) {
		Movie movie = repository.findById(id).get();
		if (movie != null)
			return converter.convertToDto(movie);
		return null;
	}

	@Override
	public List<MovieDto> getMovies(List<Long> movieIds) {
		List<Movie> movies = repository.findAllById(movieIds);
		return movies.parallelStream().map(movie -> converter.convertToDto(movie)).collect(Collectors.toList());
	}

}
