package com.maxkkk.cloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.maxkkk.cloud.order.entity.Payment;
import com.maxkkk.commons.entity.CommonResult;

@RestController
@RequestMapping("consumer/order")
public class OrderController {
	
	private final static String PAYMENT_URL = "http://localhost:8001";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("{id}")
	public CommonResult<Payment> getOrder(@PathVariable Long id) {
		CommonResult<Payment> result = restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
		return result;
	}

}
