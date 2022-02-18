package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Interface.MyConsumer;

@RestController
@EnableBinding(MyConsumer.class)
public class ConsumerController {
	
	List<String> fruits;
	@StreamListener(target=MyConsumer.GREETING)
	public void callback(List<String> fruits)
	{
		this.fruits=fruits;
		System.out.println("Received: "+fruits);
	}
	@GetMapping("/receive")
	public List<String> receiveData()
	{
		return fruits;
	}
}
