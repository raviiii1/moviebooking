package com.ravi.moviebooking.dto.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ravi.moviebooking.dto.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(content = Include.NON_NULL)
public class UserDto implements Dto {

	private Long id;
	private String name;

	@JsonProperty("email_id")
	private String emailId;

	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("country_code")
	private String contryCode;

}
