package it.jmsartemis.resources;

import it.jmsartemis.sender.Sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SenderResources {

    @Autowired
    Sender sender;

    @Value("${topic.name}")
    private String destination;

    @GetMapping
    public void sendMessage() {
        sender.sendMessage(destination, "Viva la fica");
    }
}
