package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	@Autowired
	Environment env;
	@GetMapping("/currencies/to/{valueTo}/from/{valueFrom}")
	public ConversionBean findOneCurrency(@PathVariable String valueTo, @PathVariable String valueFrom) {
		
		int port=Integer.parseInt(env.getProperty("local.server.port"));
		Optional<ConversionBean> optional = repo.findByValueToAndValueFrom(valueTo, valueFrom);
		if (optional.isPresent()) {
			ConversionBean bean= optional.get();
			bean.setPort(port);
			return bean;
		}
		return new ConversionBean();
	}

}

