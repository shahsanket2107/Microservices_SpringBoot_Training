package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Interface.MyProducer;

@RestController
@EnableBinding(MyProducer.class)
public class ProducerController {

	@Autowired
	MyProducer producer;
	@GetMapping("/publish")
	public String publishData()
	{
		List<String>payload=Arrays.asList("AMDFYkusadyf","Mango","Orange","Kiwi");
		producer.publishMessage().send(MessageBuilder.withPayload(payload).build());
		return "Published successfully!!!";
	}
}
