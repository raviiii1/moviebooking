package com.ravi.moviebooking.service.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.model.impl.EmailId;
import com.ravi.moviebooking.service.JpaJsonMarshller;

@Component
public class EmailIdMarshller extends JpaJsonMarshller<EmailId>{

	public EmailIdMarshller() {
		super(EmailId.class);
	}

}
