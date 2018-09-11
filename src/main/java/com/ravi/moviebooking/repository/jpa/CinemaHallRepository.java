package com.ravi.moviebooking.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.moviebooking.model.impl.CinemaHall;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long>{

}
