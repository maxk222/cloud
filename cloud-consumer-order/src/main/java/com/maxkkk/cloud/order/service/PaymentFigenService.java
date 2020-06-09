package com.maxkkk.cloud.order.service;

import com.maxkkk.cloud.order.config.PaymentServiceHystix;
import com.maxkkk.cloud.order.entity.Payment;
import com.maxkkk.commons.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT", fallback = PaymentServiceHystix.class)
public interface PaymentFigenService {

    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping("/payment")
    CommonResult<Payment> createPayment(@RequestBody Payment payment);
}
