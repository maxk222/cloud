package com.maxkkk.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Value("${server.port}")
    private String serverPort;

	@GetMapping("{id}")
	public String get(@PathVariable("id") Long id) {
		return "Hello Nacos Discovery: " + serverPort + "\t id: " + id;
	}
}
