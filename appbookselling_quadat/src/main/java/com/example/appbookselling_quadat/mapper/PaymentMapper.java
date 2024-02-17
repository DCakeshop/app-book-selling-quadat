package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.PaymentResponse;
import com.example.appbookselling_quadat.entity.Payment;

public class PaymentMapper {
    public static PaymentResponse convertToResponse(Payment payment){
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setOrderId(payment.getOrderId());
        paymentResponse.setAmount(payment.getAmount());
        paymentResponse.setPaymentDate(payment.getPaymentDate());
        return paymentResponse;
    }
}
