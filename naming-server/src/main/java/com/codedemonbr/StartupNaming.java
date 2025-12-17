package com.codedemonbr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StartupNaming {

	public static void main(String[] args) {
		SpringApplication.run(StartupNaming.class, args);
	}

}
