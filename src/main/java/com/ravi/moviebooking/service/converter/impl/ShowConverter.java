package com.ravi.moviebooking.service.converter.impl;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.model.impl.CinemaHall;
import com.ravi.moviebooking.model.impl.Show;
import com.ravi.moviebooking.repository.jpa.CinemaHallRepository;
import com.ravi.moviebooking.service.converter.Converter;

@Component
public class ShowConverter implements Converter<Show, ShowDto> {

	@Autowired
	CinemaHallRepository cinemaHallRepository;
	
	@Override
	public ShowDto convertToDto(@NotEmpty Show bo) {
		return new ShowDto(bo.getId(),
				bo.getTime(),
				bo.getDate(),
				bo.getCinemaHall().getId(),
				bo.getMovieId(),
				bo.getPricePerSeat(),
				bo.getBooked(),
				bo.getAvailable());
	}

	@Override
	public Show convertToBo(ShowDto dto) {
		CinemaHall cinemaHall = cinemaHallRepository.findById(dto.getCinemaHallId()).get();
		return new Show(dto.getId(),
				cinemaHall,
				dto.getTime(),
				dto.getDate(),
				dto.getPricePerSeat(),
				dto.getMovieId(),
				dto.getBooked(),
				dto.getAvailable());
	}

}
