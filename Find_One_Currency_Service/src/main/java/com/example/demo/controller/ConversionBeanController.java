package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.ConversionBean;
import com.example.demo.repo.ConversionBeanRepo;

@RestController
public class ConversionBeanController {

	@Autowired
	ConversionBeanRepo repo;

	@GetMapping("/currencies/to/{valueTo}/from/{valueFrom}")
	public ConversionBean addCurrency(@PathVariable String valueTo, @PathVariable String valueFrom) {
		Optional<ConversionBean> optional = repo.findByValueToAndValueFrom(valueTo, valueFrom);
		if (optional.isPresent()) {
			return optional.get();

		}
		return new ConversionBean();
	}

}

