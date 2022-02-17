package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.MyConfig;
import com.example.demo.pojo.MyPojo;

@RestController
public class ConfigController {
	@Autowired
	MyConfig config;
	
	@GetMapping("/values")
	public MyPojo getValues()
	{
		//return new MyPojo("compName",1234);
		return new MyPojo(config.getCompanyName(),config.getPinCode());
	}
}
