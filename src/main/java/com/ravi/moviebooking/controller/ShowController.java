package com.ravi.moviebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.moviebooking.dto.impl.ShowDto;
import com.ravi.moviebooking.facade.ShowFacade;

@Controller
@RequestMapping(path = "/show")
public class ShowController {

	@Autowired
	ShowFacade facade;

	@PutMapping(path = "")
	@ResponseBody
	public ShowDto put(@RequestBody ShowDto show) {
		return facade.put(show);
	}

	@GetMapping(path = "/{id}")
	@ResponseBody
	public ShowDto get(@PathVariable("id") Long showId) {
		return facade.get(showId);
	}

	@GetMapping(path = "/movie/{id}")
	@ResponseBody
	public List<ShowDto> getRunning(@PathVariable("id") Long movieId) {
		return facade.getRunning(movieId);
	}
}
