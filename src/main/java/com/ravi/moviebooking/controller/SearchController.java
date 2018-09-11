package com.ravi.moviebooking.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.facade.ShowFacade;

@Controller
@RequestMapping(path = "/search")
public class SearchController {

	@Autowired
	ShowFacade showFacade;
	
	@GetMapping(path = "")
	@ResponseBody
	public List<ShowDto> search(
			@RequestParam(name = "date", required = false) @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate date,
			@RequestParam(name = "time", required = false) @DateTimeFormat(pattern="HH:mm:ss") LocalTime time,
			@RequestParam(name = "movie", required = false) String movieName) {
		
		
		return showFacade.search(date, time, movieName);
	}
}
