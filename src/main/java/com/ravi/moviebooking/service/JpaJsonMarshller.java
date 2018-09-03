package com.ravi.moviebooking.service;

import javax.persistence.AttributeConverter;

import com.ravi.moviebooking.service.impl.JsonConverterUtility;

public class JpaJsonMarshller<T> implements AttributeConverter<T, String> {

    private Class<T> clazz;
    
    public JpaJsonMarshller(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        return JsonConverterUtility.convertToObject(clazz, dbData);
    }

    @Override
    public String convertToDatabaseColumn(T object) {
        return JsonConverterUtility.convertToDatabaseColumn(object);
    }
}