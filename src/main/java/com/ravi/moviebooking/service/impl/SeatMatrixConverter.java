package com.ravi.moviebooking.service.impl;

import org.springframework.stereotype.Component;

import com.ravi.moviebooking.dto.impl.SeatMatrixDto;
import com.ravi.moviebooking.model.impl.SeatMatrix;
import com.ravi.moviebooking.service.Converter;

@Component
public class SeatMatrixConverter implements Converter<SeatMatrix, SeatMatrixDto> {

	@Override
	public SeatMatrixDto convertToDto(SeatMatrix bo) {
		return new SeatMatrixDto(bo.getId(), bo.getShowId(), bo.getBooked(), bo.getAvailable());
	}

	@Override
	public SeatMatrix convertToBo(SeatMatrixDto dto) {
		return new SeatMatrix(dto.getId(), dto.getShowId(), dto.getBooked(), dto.getAvailable());
	}

}
