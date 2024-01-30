package it.jmsartemis.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    /*
    @JmsListener(destination = "${queue.name}")
    public void consume(String message) {
        log.info("Received Message Queue: " + message);
    } */


    @JmsListener(destination = "${topic.name}", containerFactory = "topicConnectionFactory" , subscription="someUniqueSubscription")
    public void consumeTopicOne(String message) {
        log.info("Received Message Topic1: " + message);
    }

}
