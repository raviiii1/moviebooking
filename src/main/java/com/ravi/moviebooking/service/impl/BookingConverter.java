package com.ravi.moviebooking.service.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.dto.impl.BookingDto;
import com.ravi.moviebooking.model.impl.Booking;
import com.ravi.moviebooking.service.Converter;

@Component
public class BookingConverter implements Converter<Booking, BookingDto>{

	@Override
	public BookingDto convertToDto(Booking bo) {
		return new BookingDto(bo.getId(), bo.getUserId(), bo.getShowId(), bo.getSeats(), bo.getPrice());
	}

	@Override
	public Booking convertToBo(BookingDto dto) {
		return new Booking(dto.getId(), dto.getUserId(), dto.getShowId(), dto.getSeats(), dto.getPrice());
	}

}
