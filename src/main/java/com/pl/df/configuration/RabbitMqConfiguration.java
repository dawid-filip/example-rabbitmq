package com.pl.df.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfiguration {

	public final static String TEST_VALUE_QUEUE = "test-value-object-queue";
	public final static String TEST_STRING_QUEUE = "test-value-string-queue";

	@Bean
	public Queue queueTestValueQueue() {
		return new Queue(TEST_VALUE_QUEUE, false);
	}

	@Bean
	public Queue queueTestStringQueue() {
		return new Queue(TEST_STRING_QUEUE, false);
	}
	
	// This comming from dependency: com.fasterxml.jackson.core/jackson-databind
	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
		return new Jackson2JsonMessageConverter();
	}
	
}
