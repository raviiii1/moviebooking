package com.ravi.moviebooking.model.impl;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ravi.moviebooking.model.Bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
public class Movie implements Bo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column(name = "running_time_minutes")
	private Integer runningTimeInMinutes;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "show_id")
	private Long showId;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	public boolean isActive() {
		return active;
	}
	
	public void isActive(Boolean active) {
		this.active = active;
	}

	public Movie(Long id, String name, Integer runningTimeInMinutes, Boolean active, Long showId) {
		super();
		this.id = id;
		this.name = name;
		this.runningTimeInMinutes = runningTimeInMinutes;
		this.active = active;
		this.showId = showId;
	}
}
