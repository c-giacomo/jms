package com.spring.messaging.jms;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/*	without Spring annotation
@Component
public class QueueListener implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("Ho sborrato: " + message);
	}
} */
