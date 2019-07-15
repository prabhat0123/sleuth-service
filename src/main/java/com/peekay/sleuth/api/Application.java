package com.peekay.sleuth.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private RestTemplate template;

	@GetMapping("/getDiscount")
	public String discount() {
		log.info("discount service called....");
		return "added discount 15%";
	}

	@GetMapping("/payment")
	public String payment() throws InterruptedException {
		log.info("payment service called with discount....");
		Thread.sleep(6000);
		return template.getForObject("http://localhost:8080/getDiscount", String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
