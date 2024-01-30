package com.apress.messaging.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class RateTopicReceiver {

	@JmsListener(destination = "${apress.jms.topic}")
	public void processTopicRate(String rate){
		System.out.println(rate);
	}
}
