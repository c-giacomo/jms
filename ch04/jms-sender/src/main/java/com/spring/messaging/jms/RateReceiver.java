package com.spring.messaging.jms;

import com.spring.messaging.domain.Rate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class RateReceiver {

	@JmsListener(destination = "${spring.jms.rate-queue}")
	public void processRate(Rate rate){
		System.out.println("lo sborro mi inonda: " + rate.toString());
	}
}
