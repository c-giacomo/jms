package it.giacomo.subscribers;

import it.giacomo.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestListener {

    @JmsListener(destination = "${emp.jms.topic}", containerFactory = "empJmsContFactory")
    public void getTestMessage(Message mess) {
        log.info("Employee listener: " + mess);
    }

//    NON FUNZIONA con destinatari multipli
//    @JmsListener(destination = "${emp.jms.topic}", containerFactory = "empJmsContFactory")
//    public void getTestMessage2(Message mess) {
//        log.info("Employee listener2: " + mess);
//    }

}
