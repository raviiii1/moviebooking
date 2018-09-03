package com.ravi.moviebooking.model.impl;

import com.ravi.moviebooking.model.Bo;

import lombok.Data;

@Data
public class PhoneNumber implements Bo{

	private static final String DEFAULT_COUNTRY_CODE = "+91";
	private String countryCode;
	private String number;

	public PhoneNumber(String countryCode, String number) {
		if (!isValidCountryCode(countryCode) && !isValidNumber(number)) {
			throw new IllegalArgumentException();
		}
		this.countryCode = countryCode;
		this.number = number;
	}

	public PhoneNumber(String number) {
		if (!isValidNumber(number)) {
			throw new IllegalArgumentException();
		}
		this.countryCode = DEFAULT_COUNTRY_CODE;
		this.number = number;
	}

	private boolean isValidNumber(String number2) {
		// TODO number validation code
		return false;
	}

	private boolean isValidCountryCode(String countryCode2) {
		// TODO country validation code
		return false;
	}

	@Override
	public String toString() {
		return new StringBuilder(countryCode).append(number).toString();
	}

}
