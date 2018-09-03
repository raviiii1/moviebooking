package com.ravi.moviebooking.model.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ravi.moviebooking.model.Bo;
import com.ravi.moviebooking.service.impl.SeatMarshller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
public class Booking implements Bo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "use_id")
	private Long userId;
	
	@Column(name = "show_id")
	private Long showId;
	
	@Convert(converter = SeatMarshller.class)
	@Column(name = "seats")
	private List<Seat> seats;
	
	@Column(name = "price")
	private double price;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public Booking(Long id, Long userId, Long showId, List<Seat> seats, double price) {
		super();
		this.id = id;
		this.userId = userId;
		this.showId = showId;
		this.seats = seats;
		this.price = price;
	}
	
}
