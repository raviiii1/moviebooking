package com.ravi.moviebooking.service.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.model.impl.Seat;
import com.ravi.moviebooking.service.JpaJsonMarshller;

@Component
public class SeatMarshller extends JpaJsonMarshller<Seat>{

	public SeatMarshller() {
		super(Seat.class);
	}

}
