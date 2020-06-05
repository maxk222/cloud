package com.maxkkk.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServerMain.class, args);
	}

}
