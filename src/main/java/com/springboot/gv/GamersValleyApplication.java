package com.springboot.gv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.gv.*"})
public class GamersValleyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamersValleyApplication.class, args);
	}

}
