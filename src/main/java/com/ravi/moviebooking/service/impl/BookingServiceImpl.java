package com.ravi.moviebooking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.moviebooking.dto.impl.BookingDto;
import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.model.impl.Booking;
import com.ravi.moviebooking.model.impl.Seat;
import com.ravi.moviebooking.repository.BookingRepository;
import com.ravi.moviebooking.service.BookingService;
import com.ravi.moviebooking.service.ShowService;

import lombok.NonNull;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository repository;
	
	@Autowired
	BookingConverter converter;
	
	@Autowired
	ShowService showService;
	
	@Transactional
	@Override
	public BookingDto book(@NonNull BookingDto booking) {
		booking.setId(null);
		ShowDto showDto = showService.getShow(booking.getShowId());
		
		if(showDto == null)
			throw new IllegalArgumentException("Show not found");
		
		Map<String, Seat> avaiableSeats = showDto.getAvailable().stream().collect(Collectors.toMap(seat -> seat.toString(), seat -> seat));
		Map<String, Seat> toBeBookedSeats =  booking.getSeats().stream().collect(Collectors.toMap(seat -> seat.toString(), seat -> seat));
		
		List<String> fileteredSeatsKey = toBeBookedSeats.keySet().stream().filter(key -> avaiableSeats.keySet().contains(key)).collect(Collectors.toList());
		
		if(fileteredSeatsKey.size() != toBeBookedSeats.keySet().size())
			throw new IllegalArgumentException("Seat already booked");
		
		List<Seat> newAvailable = showDto.getAvailable().stream().filter(seat -> !fileteredSeatsKey.contains(seat.toString())).collect(Collectors.toList());
		if(showDto.getBooked() == null)
			showDto.setBooked(new ArrayList<>());
		showDto.getBooked().addAll(booking.getSeats());
		showDto.setAvailable(newAvailable);
		booking.setPrice(showDto.getPricePerSeat() * booking.getSeats().size());
		showService.updateShow(showDto);
		return converter.convertToDto(repository.save(converter.convertToBo(booking)));
	}

	@Override
	public List<BookingDto> getBookingForUser(Long userId) {
		List<Booking> bookings = repository.findAllByUserId(userId);
		return bookings.parallelStream().map(booking -> converter.convertToDto(booking)).collect(Collectors.toList());
	}

}
