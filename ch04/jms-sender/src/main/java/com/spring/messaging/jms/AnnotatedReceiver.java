package com.spring.messaging.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnnotatedReceiver {

	@JmsListener(destination = "${spring.jms.queue}")		/* with annotation */
	public void processMessage(String content) {
		log.info("lo sborro mi sovrasta: " + content);
	}

}
