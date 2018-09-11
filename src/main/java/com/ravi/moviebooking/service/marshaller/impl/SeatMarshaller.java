package com.ravi.moviebooking.service.marshaller.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.model.impl.Seat;
import com.ravi.moviebooking.service.marshaller.JpaJsonMarshaller;

@Component
public class SeatMarshaller extends JpaJsonMarshaller<Seat>{

	public SeatMarshaller() {
		super(Seat.class);
	}

}
