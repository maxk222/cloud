package com.maxkkk.cloud.service;

import com.maxkkk.cloud.entity.Payment;

public interface PaymentService {

	Payment findById(Long id);

	Payment createPayment(Payment payment);

}
