package com.ravi.moviebooking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.BookingDto;
import com.ravi.moviebooking.model.impl.Booking;
import com.ravi.moviebooking.repository.BookingRepository;
import com.ravi.moviebooking.service.BookingService;

import lombok.NonNull;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository repository;
	
	@Autowired
	BookingConverter converter;
	
	@Override
	public BookingDto book(@NonNull BookingDto booking) {
		booking.setId(null);
		booking.setPrice(booking.getPricePerSeat() * booking.getSeats().size());
		return converter.convertToDto(repository.save(converter.convertToBo(booking)));
	}

	@Override
	public List<BookingDto> getBookingForUser(Long userId) {
		List<Booking> bookings = repository.findAllByUserId(userId);
		return bookings.parallelStream().map(booking -> converter.convertToDto(booking)).collect(Collectors.toList());
	}

}
