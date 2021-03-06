package com.maxkkk.cloud.controller;

import com.maxkkk.commons.enums.ResultCode;
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
		return new CommonResult<>(ResultCode.SUCCESS, "*********查询支付接口**********: serverPort:" + serverPort, payment);
	}
	
	@PostMapping
	public CommonResult<Payment> createPayment(@RequestBody Payment payment) {
		Payment new_payment = paymentService.createPayment(payment);
		return new CommonResult<>(ResultCode.SUCCESS, "*********创建支付接口**********: serverPort:" + serverPort, new_payment);
	}
	
}
