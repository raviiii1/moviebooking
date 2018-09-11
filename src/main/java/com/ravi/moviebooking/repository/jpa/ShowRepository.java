package com.ravi.moviebooking.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.moviebooking.model.impl.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{

	List<Show> findAllByMovieIdAndCreatedAtBetween(Long movieId, LocalDateTime now, LocalDateTime plusDays);

	List<Show> findAllByDateAndTime(LocalDate date, LocalTime time);

	List<Show> findAllByTime(LocalTime time);

	List<Show> findAllByDate(LocalDate date);

}
