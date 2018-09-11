package com.ravi.moviebooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.moviebooking.dto.impl.BookingDto;
import com.ravi.moviebooking.facade.BookingFacade;

@Controller
@RequestMapping(path = "/booking")
public class BookingController {

	@Autowired
	BookingFacade facade;
	
	@PostMapping("")
	@ResponseBody
	public BookingDto book(@Valid @RequestBody BookingDto booking){
		return facade.book(booking);
	}
	
	@GetMapping("/user/{id}")
	@ResponseBody
	public List<BookingDto> getForUser(@PathVariable("id") Long userId){
		return facade.getBookingForUser(userId);
	}
	
}
