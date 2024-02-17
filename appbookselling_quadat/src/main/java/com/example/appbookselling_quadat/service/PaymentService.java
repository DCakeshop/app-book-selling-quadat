package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.PaymentResponse;
import com.example.appbookselling_quadat.entity.Payment;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface PaymentService {
    List<PaymentResponse> getPaymentList();
    PaymentResponse getDetailPayment(int id) throws NotFoundException;
    void createPayment(Payment obj);
    void updatePayment(Payment obj);
    void delete(int id);
}
