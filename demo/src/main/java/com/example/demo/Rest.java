package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
	
	
	@GetMapping("/hello")
	public String mess() {
		return "hello";
	}

}
