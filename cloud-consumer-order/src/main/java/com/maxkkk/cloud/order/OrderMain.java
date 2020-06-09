package com.maxkkk.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.maxkkk.cloud.rules.RandomRule;

@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = RandomRule.class)
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class OrderMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderMain.class, args);
	}

}
