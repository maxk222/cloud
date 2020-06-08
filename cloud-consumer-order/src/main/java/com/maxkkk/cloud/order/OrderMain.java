package com.maxkkk.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrderMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderMain.class, args);
	}

}
