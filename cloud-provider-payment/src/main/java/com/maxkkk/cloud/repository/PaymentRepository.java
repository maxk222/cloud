package com.maxkkk.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxkkk.cloud.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
