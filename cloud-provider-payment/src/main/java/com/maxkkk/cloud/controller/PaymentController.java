package com.maxkkk.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.maxkkk.cloud.entity.Payment;
import com.maxkkk.cloud.service.PaymentService;
import com.maxkkk.commons.entity.CommonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	@Value("${server.port}")
	private Integer serverPort;

	@GetMapping("{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.findById(id);
		log.info("*********查询支付接口**********: serverPort:" + serverPort + payment);
		return new CommonResult<>(payment);
	}
	
	@PostMapping
	public CommonResult<Payment> createPayment(@RequestBody Payment payment) {
		Payment new_payment = paymentService.createPayment(payment);
		log.info("*********新建支付**********:" + new_payment);
		return new CommonResult<>(new_payment);
	}
	
}
