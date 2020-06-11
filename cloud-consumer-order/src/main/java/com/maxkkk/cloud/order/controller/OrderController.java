package com.maxkkk.cloud.order.controller;

import com.maxkkk.cloud.order.service.PaymentFigenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maxkkk.cloud.order.entity.Payment;
import com.maxkkk.commons.entity.CommonResult;

@RestController
@RequestMapping("consumer/order")
public class OrderController {

    @Autowired
    private PaymentFigenService figenService;

    @GetMapping("{id}")
    public CommonResult<Payment> getOrder(@PathVariable Long id) {
        //CommonResult<Payment> result = restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        CommonResult<Payment> result = figenService.getPaymentById(id);
        return result;
    }

    @PostMapping
    public CommonResult<Payment> createPayment(@RequestBody Payment payment) {
        CommonResult<Payment> result = figenService.createPayment(payment);
        return result;
    }

}
