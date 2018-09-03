package com.ravi.moviebooking.service;

import java.util.List;

import com.ravi.moviebooking.dto.impl.BookingDto;

public interface BookingService {

	public BookingDto book(BookingDto booking);

	public List<BookingDto> getBookingForUser(Long userId);

}
