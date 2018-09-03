package com.ravi.moviebooking.service.impl;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.model.impl.Show;
import com.ravi.moviebooking.service.Converter;

@Component
public class ShowConverter implements Converter<Show, ShowDto> {

	@Autowired
	private SeatMatrixConverter matrixConverter;

	@Autowired
	CinemaHallConverter cinemaHallConverter;
	
	@Override
	public ShowDto convertToDto(@NotEmpty Show bo) {
		return new ShowDto(bo.getId(),
				bo.getTime(),
				bo.getDate(),
				cinemaHallConverter.convertToDto(bo.getCinemaHall()),
				bo.getMovieId(),
				bo.getPricePerSeat(),
				matrixConverter.convertToDto(bo.getSeatMatrix()));
	}

	@Override
	public Show convertToBo(ShowDto dto) {
		return new Show(dto.getId(),
				cinemaHallConverter.convertToBo(dto.getCinemaHallDto()),
				dto.getTime(),
				dto.getDate(),
				dto.getPricePerSeat(),
				dto.getMovieId(),
				matrixConverter.convertToBo(dto.getMatrix()));
	}

}
