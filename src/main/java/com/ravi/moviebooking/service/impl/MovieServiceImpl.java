package com.ravi.moviebooking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.MovieDto;
import com.ravi.moviebooking.model.impl.Movie;
import com.ravi.moviebooking.repository.jpa.MovieRepository;
import com.ravi.moviebooking.service.MovieService;
import com.ravi.moviebooking.service.converter.impl.MovieConverter;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository repository;

	@Autowired
	MovieConverter converter;

	@Override
	public List<MovieDto> getAllActive() {
		List<Movie> activeMovies = repository.findAllByActive(true);
		return activeMovies.parallelStream().map(mov -> converter.convertToDto(mov)).collect(Collectors.toList());
	}

	@Override
	public MovieDto get(Long id) {
		Movie movie = repository.findById(id).get();
		if (movie != null)
			return converter.convertToDto(movie);
		return null;
	}

	@Override
	public List<MovieDto> getAll(List<Long> movieIds) {
		List<Movie> movies = repository.findAllById(movieIds);
		return movies.parallelStream().map(movie -> converter.convertToDto(movie)).collect(Collectors.toList());
	}

	@Override
	public MovieDto put(MovieDto movieDto) {
		movieDto.setId(null);
		return converter.convertToDto(repository.save(converter.convertToBo(movieDto)));
	}

	@Override
	public boolean delete(Long id) {
		Movie movie = repository.findById(id).get();
		if (movie != null) {
			movie.setActive(false);
			repository.save(movie);
			return true;
		}
		return false;
	}

}
