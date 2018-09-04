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
@Table(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Bo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column(name = "running_time_minutes")
	private Integer runningTimeInMinutes;
	
	@Column(name = "active")
	private boolean active;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	public boolean isActive() {
		return active;
	}
	
	public void isActive(boolean active) {
		this.active = active;
	}

	public Movie(Long id, String name, Integer runningTimeInMinutes, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.runningTimeInMinutes = runningTimeInMinutes;
		this.active = active;
	}
}
