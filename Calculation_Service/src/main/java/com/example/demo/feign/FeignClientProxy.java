package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.pojo.ConversionCalculationBean;

@FeignClient(value="find-one")//,url="http://localhost:8082")
public interface FeignClientProxy {
	@GetMapping("currencies/to/{valueTo}/from/{valueFrom}")
	ConversionCalculationBean getValue(@PathVariable("valueTo") String valueTo,@PathVariable("valueFrom") String valueFrom);
}
