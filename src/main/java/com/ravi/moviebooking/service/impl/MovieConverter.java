package com.ravi.moviebooking.service.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.dto.impl.MovieDto;
import com.ravi.moviebooking.model.impl.Movie;
import com.ravi.moviebooking.service.Converter;

@Component
public class MovieConverter implements Converter<Movie, MovieDto> {

	@Override
	public MovieDto convertToDto(Movie bo) {
		return new MovieDto(bo.getId(), bo.getName(), bo.getRunningTimeInMinutes(), bo.getActive(), bo.getShowId());
	}

	@Override
	public Movie convertToBo(MovieDto dto) {
		return new Movie(dto.getId(), dto.getName(), dto.getRunningTimeInMinutes(), dto.getActive(), dto.getShowId());
	}

}
