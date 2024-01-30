package it.giacomo.publishers;

import it.giacomo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Topic;

@Component
public class TestSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send() throws JMSException {
        Topic testTopic = jmsTemplate.getConnectionFactory().createConnection()
                .createSession().createTopic("TestTopic");

        Message mess = Message.builder().name("Giacomo").surname("Chiavolotti").build();
        jmsTemplate.convertAndSend(testTopic, mess);
    }

}
