package com.maxkkk.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxkkk.cloud.entity.Payment;
import com.maxkkk.cloud.repository.PaymentRepository;
import com.maxkkk.cloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repository;

	@Override
	public Payment findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Payment createPayment(Payment payment) {
		Payment result = repository.saveAndFlush(payment);
		return result;
	}
	
}
