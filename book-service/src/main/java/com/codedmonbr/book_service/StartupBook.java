package com.codedmonbr.book_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StartupBook {

	public static void main(String[] args) {
		SpringApplication.run(StartupBook.class, args);
	}

}
