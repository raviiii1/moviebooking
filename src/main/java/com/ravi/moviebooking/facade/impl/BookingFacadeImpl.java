package com.ravi.moviebooking.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ravi.moviebooking.dto.impl.BookingDto;
import com.ravi.moviebooking.facade.BookingFacade;
import com.ravi.moviebooking.model.impl.Seat;
import com.ravi.moviebooking.model.impl.Show;
import com.ravi.moviebooking.service.BookingService;
import com.ravi.moviebooking.service.ShowService;
import com.ravi.moviebooking.service.converter.impl.BookingConverter;

import lombok.NonNull;

public class BookingFacadeImpl implements BookingFacade {

	@Autowired
	ShowService showService;

	@Autowired
	BookingService bookingService;

	@Autowired
	BookingConverter converter;

	@Transactional
	public BookingDto book(@NonNull BookingDto booking) {
		Show showBo = showService.get(booking.getShowId());
		if (showBo == null)
			throw new IllegalArgumentException("Show not found");

		Map<String, Seat> avaiableSeats = showBo.getAvailable()
				.stream()
				.collect(Collectors.toMap(seat -> seat.toString(), seat -> seat));
		
		Map<String, Seat> toBeBookedSeats = booking.getSeats()
				.stream()
				.collect(Collectors.toMap(seat -> seat.toString(), seat -> seat));

		List<String> fileteredSeatsKey = toBeBookedSeats.keySet()
				.stream()
				.filter(key -> avaiableSeats.keySet().contains(key))
				.collect(Collectors.toList());

		if (fileteredSeatsKey.size() != toBeBookedSeats.keySet().size())
			throw new IllegalArgumentException("Seat already booked");

		List<Seat> newAvailable = showBo.getAvailable()
				.stream()
				.filter(seat -> !fileteredSeatsKey.contains(seat.toString()))
				.collect(Collectors.toList());
		
		if (showBo.getBooked() == null)
			showBo.setBooked(new ArrayList<>());
		
		showBo.getBooked().addAll(booking.getSeats());
		showBo.setAvailable(newAvailable);
		booking.setPrice(showBo.getPricePerSeat() * booking.getSeats().size());
		
		showService.update(showBo);
		return converter.convertToDto(bookingService.save(converter.convertToBo(booking)));
	}

	@Override
	public List<BookingDto> getBookingForUser(@NonNull Long userId) {
		return bookingService.getBookingForUser(userId)
				.parallelStream()
				.map(booking -> converter.convertToDto(booking))
				.collect(Collectors.toList());
	}

}
