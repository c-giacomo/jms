package it.jmsartemis.sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender  {

    private final JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, String message){
        this.jmsTemplate.convertAndSend(destination, message);
    }
}
