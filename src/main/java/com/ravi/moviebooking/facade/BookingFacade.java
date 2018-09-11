package com.ravi.moviebooking.facade;

import java.util.List;

import com.ravi.moviebooking.dto.impl.BookingDto;

public interface BookingFacade {

	BookingDto book(BookingDto booking);

	List<BookingDto> getBookingForUser(Long userId);

}
