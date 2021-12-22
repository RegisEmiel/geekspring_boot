package ru.geekbrains.geekspring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GeekspringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeekspringBootApplication.class, args);
	}

	@RequestMapping("/test")
	public String helloWorld() {
		return "Hello World";
	}
}
