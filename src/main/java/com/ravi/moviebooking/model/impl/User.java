package com.ravi.moviebooking.model.impl;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ravi.moviebooking.model.Bo;
import com.ravi.moviebooking.service.marshaller.impl.EmailIdMarshaller;
import com.ravi.moviebooking.service.marshaller.impl.PhoneNumberMarshaller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Bo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Convert(converter = EmailIdMarshaller.class)
	@Column(name = "email_id")
	private EmailId emailId;
	
	@Convert(converter = PhoneNumberMarshaller.class)
	@Column(name = "phone_number")
	private PhoneNumber phoneNumber;
}