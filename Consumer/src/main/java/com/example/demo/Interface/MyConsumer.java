package com.example.demo.Interface;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MyConsumer {
	public String GREETING = "greetingChannel";
	@Input(GREETING)
	public SubscribableChannel getMessage();

}
