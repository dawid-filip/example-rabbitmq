package com.pl.df.example.services;

import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pl.df.example.controllers.dto.TestValue;

import lombok.extern.log4j.Log4j2;

import static com.pl.df.configuration.RabbitMqConfiguration.*;

@Component
@Log4j2
public class ProducerService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public TestValue sendTestValuetMessage() {
		int id = createId();
		TestValue testValue = new TestValue(id, "Test value is " + id);
		rabbitTemplate.convertAndSend(TEST_VALUE_QUEUE, testValue);
		
		log.info("-> Send " + testValue + " message into <" + TEST_VALUE_QUEUE + "> queue");
		return testValue;
	}
	
	public String sendStringValueMessage() {
		String stringMessage = "Test string message is: " + createId();
		rabbitTemplate.convertAndSend(TEST_STRING_QUEUE, stringMessage);
		
		log.info("-> Send " + stringMessage + " message into <" + TEST_STRING_QUEUE + "> queue");
		return stringMessage;
	}
	
	private int createId() {
		return new Random().nextInt(Integer.MAX_VALUE);
	}
	
}
