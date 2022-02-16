package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	@RequestMapping(value="/messages", method=RequestMethod.GET)
	public String getMessage() {
		return "Welcome to REST framework!!!";
	}

	@GetMapping("/messages/{name}")
	public String getMessage(@PathVariable String name) {
		return "Hello " + name + " Welcome to REST framework!!!";
	}
	
	@GetMapping("/messages/id/{id}")
	public String getMessage(@PathVariable int id) {
		int tp=id+100;
		return "Hello " + tp + " Welcome to REST framework!!!";
	}

}
