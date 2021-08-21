package com.pl.df.example.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.pl.df.example.controllers.dto.TestValue;

import lombok.extern.log4j.Log4j2;

import static com.pl.df.configuration.RabbitMqConfiguration.*;

@Component
@Log4j2
public class ReceiverService {
	
	@RabbitListener(queues = TEST_VALUE_QUEUE)
	public void receiveTestValueObjectMessage(TestValue testValueJson) {
		log.info("<- Recive " + testValueJson.toString() + " message from <" + TEST_STRING_QUEUE + "> queue");
	}
	
	@RabbitListener(queues = TEST_STRING_QUEUE)
	public void receiveTestStringValueMessage(String testStringValueJson) {
		log.info("<- Recive " + testStringValueJson + " message from <" + TEST_STRING_QUEUE + "> queue");
	}
	
}
