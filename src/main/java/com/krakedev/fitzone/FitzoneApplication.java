package com.krakedev.fitzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.krakedev")

@EnableJpaRepositories(basePackages="com.krakedev")

@EntityScan(basePackages="com.krakedev")
public class FitzoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitzoneApplication.class, args);
	}

}
