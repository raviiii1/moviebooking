package com.ravi.moviebooking.service.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.dto.impl.UserDto;
import com.ravi.moviebooking.model.impl.EmailId;
import com.ravi.moviebooking.model.impl.PhoneNumber;
import com.ravi.moviebooking.model.impl.User;
import com.ravi.moviebooking.service.Converter;

@Component
public class UserConverter implements Converter<User, UserDto>{

	@Override
	public UserDto convertToDto(User bo) {
		return new UserDto(bo.getId(), bo.getName(), bo.getEmailId().getId(), bo.getPhoneNumber().getNumber(), bo.getPhoneNumber().getCountryCode());
	}

	@Override
	public User convertToBo(UserDto dto) {
		return new User(dto.getId(), dto.getName(), new EmailId(dto.getEmailId()), new PhoneNumber(dto.getContryCode(), dto.getPhoneNumber()));
	}

}
