package com.pl.df.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@EnableScheduling
@Log4j2
public class Schduler {

	@Autowired
	private ProducerService producerService;
	
	@Scheduled(fixedDelay = 1 * 10_000)
	public void start() {
		log.info("Starting sending messages...");
		
		producerService.sendStringValueMessage();
		producerService.sendTestValuetMessage();
	}
	
}
