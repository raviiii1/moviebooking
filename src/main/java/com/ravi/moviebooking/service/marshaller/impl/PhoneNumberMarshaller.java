package com.ravi.moviebooking.service.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.model.impl.PhoneNumber;
import com.ravi.moviebooking.service.JpaJsonMarshller;

@Component
public class PhoneNumberMarshller extends JpaJsonMarshller<PhoneNumber>{

	public PhoneNumberMarshller() {
		super(PhoneNumber.class);
	}

}
