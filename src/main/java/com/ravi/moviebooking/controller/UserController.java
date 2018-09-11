package com.ravi.moviebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.moviebooking.dto.impl.UserDto;
import com.ravi.moviebooking.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService service;
	
	@PutMapping
	@ResponseBody
	public UserDto put(@RequestBody UserDto dto) {
		return service.put(dto);
	}
	
}
