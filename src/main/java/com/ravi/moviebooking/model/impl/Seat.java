package com.ravi.moviebooking.model.impl;

import com.ravi.moviebooking.model.Bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat implements Bo{

	int row;
	int col;

//	@Override
//	public String toString() {
//		return new StringBuilder((char)(row%65))
//				.append(col)
//				.toString();
//	}
//	
}
