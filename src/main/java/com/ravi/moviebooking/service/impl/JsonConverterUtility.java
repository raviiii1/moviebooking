package com.ravi.moviebooking.service.impl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverterUtility {

	private static ObjectMapper MAPPER = null;

	public static <T> T convertToObject(Class<T> type, String json) {
		T object = null;
		try {
			object = getObjectMapper().readValue(json, type);
		} catch (IOException ex) {

		}
		return object;
	}

	public static <T> String convertToDatabaseColumn(T object) {
		String objectToString = null;
		try {
			objectToString = getObjectMapper().writeValueAsString(object);
		} catch (JsonProcessingException ex) {

		}
		return objectToString;
	}

	private static ObjectMapper getObjectMapper() {
		if (MAPPER == null) {
			MAPPER = new ObjectMapper();
			MAPPER.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
			MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
		return MAPPER;
	}
}