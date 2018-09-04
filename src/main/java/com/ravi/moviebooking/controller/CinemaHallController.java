package com.ravi.moviebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.moviebooking.dto.impl.CinemaHallDto;
import com.ravi.moviebooking.service.CinemaHallService;

@Controller
@RequestMapping(path = "/cinema-hall")
public class CinemaHallController {

	@Autowired
	CinemaHallService service;
	
	@PutMapping
	@ResponseBody
	public CinemaHallDto putCinemaHall(@RequestBody CinemaHallDto dto) {
		return service.putCinemaHall(dto);
	}
}
