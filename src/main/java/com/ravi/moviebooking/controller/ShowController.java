package com.ravi.moviebooking.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.moviebooking.dto.impl.SeatMatrixDto;
import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.service.ShowService;

@Controller
@RequestMapping(path = "/show")
public class ShowController {

	@Autowired
	ShowService service;
	
	@PutMapping(path = "")
	@ResponseBody
	public ShowDto getShow(@RequestBody ShowDto show) {
		return service.putShow(show);
	}
	
	@GetMapping(path = "/{id}")
	@ResponseBody
	public ShowDto getShow(@PathParam("id") Long showId) {
		return service.getShow(showId);
	}
	
	@GetMapping(path = "/{id}/seat_matrix")
	@ResponseBody
	public SeatMatrixDto getShowSeatMatrix(@PathParam("id") Long showId) {
		return service.getShowSeatMatrix(showId);
	}
	
	@GetMapping(path = "/movie/{id}")
	@ResponseBody
	public List<ShowDto> getMovieShows(@PathParam("id") Long movieId){
		return service.getMovieShows(movieId);
	}
}
