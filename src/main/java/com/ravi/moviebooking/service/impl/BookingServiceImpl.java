package com.ravi.moviebooking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.model.impl.Booking;
import com.ravi.moviebooking.repository.jpa.BookingRepository;
import com.ravi.moviebooking.service.BookingService;

import lombok.NonNull;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository repository;

	public Booking save(@NonNull Booking booking) {
		booking.setId(null);
		return repository.save(booking);
	}
	
	@Override
	public List<Booking> getBookingForUser(Long userId) {
		return repository.findAllByUserId(userId);
	}

}
