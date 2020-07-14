package com.maxkkk.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PaymentMain.class, args);
	}

}
