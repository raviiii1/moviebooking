package com.ravi.moviebooking.service.marshaller.impl;

import java.util.List;

import javax.persistence.AttributeConverter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ravi.moviebooking.model.impl.Seat;
import com.ravi.moviebooking.service.impl.JsonConverterUtility;

@Component
public class SeatListMarshaller implements AttributeConverter<List<Seat>, String> {

	@Override
	public String convertToDatabaseColumn(List<Seat> attribute) {
		return JsonConverterUtility.convertToDatabaseColumn(attribute);
	}

	@Override
	public List<Seat> convertToEntityAttribute(String dbData) {
		return JsonConverterUtility.convertToObject(new TypeReference<List<Seat>>(){}, dbData);
	}

}