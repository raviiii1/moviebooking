package com.ravi.moviebooking.service;

import java.util.List;

import com.ravi.moviebooking.model.impl.Booking;

public interface BookingService {

	public Booking save(Booking booking);

	public List<Booking> getBookingForUser(Long userId);

}
