package com.ravi.moviebooking.service.marshaller.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.model.impl.EmailId;
import com.ravi.moviebooking.service.marshaller.JpaJsonMarshaller;

@Component
public class EmailIdMarshaller extends JpaJsonMarshaller<EmailId>{

	public EmailIdMarshaller() {
		super(EmailId.class);
	}

}
