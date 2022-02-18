package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.feign.FeignClientProxy;
import com.example.demo.pojo.ConversionCalculationBean;

@RestController
public class CalculationController {
	
	// This microservice is communicating and finding data from Find_One_Currency_Service
	@GetMapping("/currency-conversion/to/{valueTo}/from/{valueFrom}/quantity/{quantity}")
	public ConversionCalculationBean calculation(@PathVariable String valueTo,@PathVariable String valueFrom,@PathVariable BigDecimal quantity )
	{
		ConversionCalculationBean bean=null;
		
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("valueTo", valueTo);
		uriVariables.put("valueFrom",valueFrom);
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<ConversionCalculationBean> entity= restTemplate.getForEntity("http://localhost:8082/currencies/to/{valueTo}/from/{valueFrom}",ConversionCalculationBean.class, uriVariables);
		bean=entity.getBody();
		bean.setQuantity(quantity);
		BigDecimal ans;
		ans=bean.getConversionMultiple().multiply(bean.getQuantity());
		bean.setCalculatedAmount(ans);
		return bean;
	}
	@Autowired
	FeignClientProxy proxy;	
	@GetMapping("/currency-conversion-feign/to/{valueTo}/from/{valueFrom}/quantity/{quantity}")
	public ConversionCalculationBean calculation_feign(@PathVariable String valueTo,@PathVariable String valueFrom,@PathVariable BigDecimal quantity )
	{
		ConversionCalculationBean bean=null;
		bean=proxy.getValue(valueTo, valueFrom);
		bean.setQuantity(quantity);
		BigDecimal ans;
		ans=bean.getConversionMultiple().multiply(bean.getQuantity());
		bean.setCalculatedAmount(ans);
		return bean;
	}
}
