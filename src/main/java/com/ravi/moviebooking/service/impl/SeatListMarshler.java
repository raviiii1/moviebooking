package com.ravi.moviebooking.service.impl;

import java.util.List;

import javax.persistence.AttributeConverter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ravi.moviebooking.model.impl.Seat;

@Component
public class SeatListMarshler implements AttributeConverter<List<Seat>, String> {

	@Override
	public String convertToDatabaseColumn(List<Seat> attribute) {
		return JsonConverterUtility.convertToDatabaseColumn(attribute);
	}

	@Override
	public List<Seat> convertToEntityAttribute(String dbData) {
		return JsonConverterUtility.convertToObject(new TypeReference<List<Seat>>(){}, dbData);
	}

}