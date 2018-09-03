package com.ravi.moviebooking.service;

public interface Converter<Bo, Dto> {

	Dto convertToDto(Bo bo);

	Bo convertToBo(Dto dto);
}
