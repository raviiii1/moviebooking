package com.ravi.moviebooking.model.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ravi.moviebooking.model.Bo;
import com.ravi.moviebooking.service.impl.SeatMarshller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "seat_matrix")
@Data
@AllArgsConstructor
public class SeatMatrix implements Bo {

	@Id
	private Long id;

	@Column(name = "show_id")
	private Long showId;

	@Convert(converter = SeatMarshller.class)
	@Column
	private List<Seat> booked;

	@Convert(converter = SeatMarshller.class)
	@Column
	private List<Seat> available;
	
}
