package com.ravi.moviebooking.service.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.dto.impl.CinemaHallDto;
import com.ravi.moviebooking.model.impl.CinemaHall;
import com.ravi.moviebooking.service.Converter;

@Component
public class CinemaHallConverter implements Converter<CinemaHall, CinemaHallDto>{

	@Override
	public CinemaHallDto convertToDto(CinemaHall bo) {
		return new CinemaHallDto(bo.getId(), bo.getSeatCount(), bo.getRowCount(), bo.getColumnCount());
	}

	@Override
	public CinemaHall convertToBo(CinemaHallDto dto) {
		return new CinemaHall(dto.getId(), dto.getSeatCount(), dto.getRowCount(), dto.getColumnCount());
	}

}
