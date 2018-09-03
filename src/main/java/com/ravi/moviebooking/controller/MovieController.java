package com.ravi.moviebooking.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.moviebooking.dto.impl.MovieDto;
import com.ravi.moviebooking.service.MovieService;

@Controller
@RequestMapping(path = "/movie")
public class MovieController {

	@Autowired
	MovieService service;
	
	@GetMapping(path = "/all")
	@ResponseBody
	public List<MovieDto> getMovies(){
		return service.getAllActiveMovies();
	}
	
	@GetMapping(path = "/{id}")
	@ResponseBody
	public MovieDto getMovie(@PathParam("id") Long id){
		return service.getMovie(id);
	}

}
