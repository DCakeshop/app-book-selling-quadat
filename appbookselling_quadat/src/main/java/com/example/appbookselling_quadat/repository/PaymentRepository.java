package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findPaymentById(int id);
    Payment findPaymentByAmount(double amount);
}
