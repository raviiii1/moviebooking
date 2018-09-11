package com.ravi.moviebooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.CinemaHallDto;
import com.ravi.moviebooking.repository.jpa.CinemaHallRepository;
import com.ravi.moviebooking.service.CinemaHallService;
import com.ravi.moviebooking.service.converter.impl.CinemaHallConverter;

@Service
public class CinemaHallServiceImpl implements CinemaHallService{

	@Autowired
	CinemaHallRepository repository;
	
	@Autowired
	CinemaHallConverter converter;
	
	@Override
	public CinemaHallDto put(CinemaHallDto dto) {
		dto.setId(null);
		return converter.convertToDto(repository.save(converter.convertToBo(dto)));
	}

	@Override
	public CinemaHallDto get(Long id) {
		return converter.convertToDto(repository.findById(id).get());
	}

}
