package com.ravi.moviebooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.CinemaHallDto;
import com.ravi.moviebooking.repository.CinemaHallRepository;
import com.ravi.moviebooking.service.CinemaHallService;

@Service
public class CinemaHallServiceImpl implements CinemaHallService{

	@Autowired
	CinemaHallRepository repository;
	
	@Autowired
	CinemaHallConverter converter;
	
	@Override
	public CinemaHallDto putCinemaHall(CinemaHallDto dto) {
		dto.setId(null);
		return converter.convertToDto(repository.save(converter.convertToBo(dto)));
	}

	@Override
	public CinemaHallDto getCinemaHall(Long id) {
		return converter.convertToDto(repository.findById(id).get());
	}

}
