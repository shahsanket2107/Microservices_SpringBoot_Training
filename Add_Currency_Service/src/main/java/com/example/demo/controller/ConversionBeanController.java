package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.ConversionBean;
import com.example.demo.repo.ConversionBeanRepo;

@RestController
public class ConversionBeanController {
	@Autowired
	ConversionBeanRepo repo;
	
	@PostMapping("/currencies")
	public ConversionBean addCurrency(@RequestBody ConversionBean bean)
		{
			return repo.save(bean);
		}
	
}
