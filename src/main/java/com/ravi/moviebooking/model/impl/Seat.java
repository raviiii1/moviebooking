package com.ravi.moviebooking.model.impl;

import com.ravi.moviebooking.model.Bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seat implements Bo{

	int rowNumber;
	int columnNumber;

	@Override
	public String toString() {
		return new StringBuilder("[")
				.append(rowNumber)
				.append(", ")
				.append(columnNumber)
				.append("]")
				.toString();
	}
}
