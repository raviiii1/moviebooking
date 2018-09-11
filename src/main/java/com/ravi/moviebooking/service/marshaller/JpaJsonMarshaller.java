package com.ravi.moviebooking.service.marshaller;

import javax.persistence.AttributeConverter;

import com.ravi.moviebooking.service.impl.JsonConverterUtility;

public class JpaJsonMarshaller<T> implements AttributeConverter<T, String> {

    private Class<T> clazz;
    
    public JpaJsonMarshaller(Class<T> clazz) {
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