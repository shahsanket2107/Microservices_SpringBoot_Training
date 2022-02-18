package com.example.demo.Interface;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyProducer {
	
	static String MESSAGE="messages"; //Channel Name
	
	@Output(MESSAGE)
	MessageChannel publishMessage();

}
