package it.giacomo;

import it.giacomo.publishers.TestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Topic;
import javax.management.j2ee.statistics.JCAConnectionStats;

@SpringBootApplication
@EnableJms
public class JmsPubSubApplication implements CommandLineRunner {

    @Autowired
    TestSender testSender;

    public static void main(String[] args) {
        SpringApplication.run(JmsPubSubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testSender.send();;
    }
}
