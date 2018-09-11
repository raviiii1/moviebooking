package com.ravi.moviebooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.UserDto;
import com.ravi.moviebooking.repository.jpa.UserRepository;
import com.ravi.moviebooking.service.UserService;
import com.ravi.moviebooking.service.converter.impl.UserConverter;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;

	@Autowired
	UserConverter converter;
	
	@Override
	public UserDto put(UserDto dto) {
		return converter.convertToDto(repository.save(converter.convertToBo(dto)));
	}

}
