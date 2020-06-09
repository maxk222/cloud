package com.maxkkk.cloud.order.config;

import org.springframework.stereotype.Component;

import com.maxkkk.cloud.order.entity.Payment;
import com.maxkkk.cloud.order.service.PaymentFigenService;
import com.maxkkk.commons.entity.CommonResult;

@Component
public class PaymentServiceHystix implements PaymentFigenService{

	@Override
	public CommonResult<Payment> getPaymentById(Long id) {
		System.out.println("123");
		return null;
	}

	@Override
	public CommonResult<Payment> createPayment(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

}
