package com.ravi.moviebooking.model.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
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
import com.ravi.moviebooking.service.impl.SeatListMarshler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie_show")
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
	
	@Convert(converter = SeatListMarshler.class)
	private List<Seat> booked;
	
	@Convert(converter = SeatListMarshler.class)
	private List<Seat> available;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public Show(Long id, CinemaHall cinemaHall, LocalTime time, LocalDate date, Double pricePerSeat, Long movieId,
			List<Seat> booked, List<Seat> available) {
		super();
		this.id = id;
		this.cinemaHall = cinemaHall;
		this.time = time;
		this.date = date;
		this.pricePerSeat = pricePerSeat;
		this.movieId = movieId;
		this.booked = booked;
		this.available = available;
	}
}
