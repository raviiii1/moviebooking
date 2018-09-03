package com.ravi.moviebooking.model.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ravi.moviebooking.model.Bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "show")
public class Show implements Bo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "cinema_hall_id")
	CinemaHall cinemaHall;
	
	@Column(name = "time")
	LocalTime time;
	
	@Column(name = "date")
	LocalDate date;
	
	@Column(name = "price_per_seat")
	Double pricePerSeat; 
	
	@Column(name = "movie_id")
	Long movieId;
	
	@OneToOne
	@JoinColumn(name = "seat_matrix_id")
	SeatMatrix seatMatrix;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public Show(Long id, CinemaHall cinemaHall, LocalTime time, LocalDate date, Double pricePerSeat, Long movieId,
			SeatMatrix seatMatrix) {
		super();
		this.id = id;
		this.cinemaHall = cinemaHall;
		this.time = time;
		this.date = date;
		this.pricePerSeat = pricePerSeat;
		this.movieId = movieId;
		this.seatMatrix = seatMatrix;
	}
	
}
