package com.ravi.moviebooking.model.impl;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ravi.moviebooking.model.Bo;
import com.ravi.moviebooking.service.impl.EmailIdMarshller;
import com.ravi.moviebooking.service.impl.PhoneNumberMarshller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
public class User implements Bo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Convert(converter = EmailIdMarshller.class)
	@Column(name = "email_id")
	private EmailId emailId;
	
	@Convert(converter = PhoneNumberMarshller.class)
	@Column(name = "phone_number")
	private PhoneNumber phoneNumber;
}