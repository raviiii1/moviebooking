package com.ravi.moviebooking.model.impl;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ravi.moviebooking.model.Bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cinema_hall")
public class CinemaHall implements Bo{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "seat_count")
	private Integer seatCount;
	
	@Column(name = "row_count")
	private Integer rowCount;
	
	@Column(name = "column_count")
	private Integer columnCount;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public CinemaHall(Long id, Integer seatCount, Integer rowCount, Integer columnCount) {
		super();
		this.id = id;
		this.seatCount = seatCount;
		this.rowCount = rowCount;
		this.columnCount = columnCount;
	}
}
