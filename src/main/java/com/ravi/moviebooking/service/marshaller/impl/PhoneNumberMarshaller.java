package com.ravi.moviebooking.service.marshaller.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.model.impl.PhoneNumber;
import com.ravi.moviebooking.service.marshaller.JpaJsonMarshaller;

@Component
public class PhoneNumberMarshaller extends JpaJsonMarshaller<PhoneNumber>{

	public PhoneNumberMarshaller() {
		super(PhoneNumber.class);
	}

}
