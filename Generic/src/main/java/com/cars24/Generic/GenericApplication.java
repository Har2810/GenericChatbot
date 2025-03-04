package com.cars24.Generic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
//@SpringBootApplication
public class GenericApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericApplication.class, args);
	}

}
