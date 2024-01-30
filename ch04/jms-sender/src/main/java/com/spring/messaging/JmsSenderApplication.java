package com.spring.messaging;

import com.spring.messaging.config.JMSProperties;
import com.spring.messaging.domain.Rate;
import com.spring.messaging.jms.RateSender;
import com.spring.messaging.jms.SimpleSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Date;

@SpringBootApplication
public class JmsSenderApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	SimpleSender sender;

	@Autowired
	RateSender rateSender;

	@Autowired
	JMSProperties props;

	public static void main(String[] args) {
		SpringApplication.run(JmsSenderApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JmsSenderApplication.class);
	}

	@Override
	public void run(String... strings) throws Exception {
		sender.sendMessage(props.getQueue(), "Hello World");

		/* This code is for the Rates
		rateSender.sendCurrency(props.getRateQueue(), new Rate("EUR",0.88857F,new Date())); */

	}

}
