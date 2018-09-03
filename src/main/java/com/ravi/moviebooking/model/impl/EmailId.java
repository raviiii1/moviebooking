package com.ravi.moviebooking.model.impl;

import com.ravi.moviebooking.model.Bo;

import lombok.Data;

@Data
public class EmailId implements Bo{

	private String id;
	
	public EmailId(String emailId) {
		if(isValid(emailId))
			id = emailId;
	}
	
	private boolean isValid(String emailId) {
		// email validation code goes here
		return true;
	}
	
	@Override
	public String toString() {
		return id;
	}
}
