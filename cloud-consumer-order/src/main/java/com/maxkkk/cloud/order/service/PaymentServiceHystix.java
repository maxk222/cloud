package com.maxkkk.cloud.order.service;

import org.springframework.stereotype.Component;

import com.maxkkk.cloud.order.entity.Payment;
import com.maxkkk.commons.entity.CommonResult;
import com.maxkkk.commons.enums.ResultCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PaymentServiceHystix implements PaymentFigenService {

	@Override
	public CommonResult<Payment> getPaymentById(Long id) {
		log.info("调用断开啦");
		return new CommonResult<Payment>(ResultCode.FAILED, null);
	}

	@Override
	public CommonResult<Payment> createPayment(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

}
