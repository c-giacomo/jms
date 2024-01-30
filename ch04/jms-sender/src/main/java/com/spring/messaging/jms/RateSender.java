package com.spring.messaging.jms;

import com.spring.messaging.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class RateSender {

	private JmsTemplate jmsTemplate;
	
	@Autowired
	public RateSender(JmsTemplate jmsTemplate){
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendCurrency(String destination, Rate rate){
		this.jmsTemplate.convertAndSend(destination,rate);
	}
	
	/* This code is for the reply-to-queue section

	@JmsListener(destination="${spring.jms.rate-reply-queue}")
	public void process(String body,@Header("CODE") String code){
		
	}

	*/
}
