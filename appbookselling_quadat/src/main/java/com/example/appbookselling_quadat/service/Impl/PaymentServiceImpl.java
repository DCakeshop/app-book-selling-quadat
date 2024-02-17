package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.PaymentResponse;
import com.example.appbookselling_quadat.entity.Payment;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.PaymentMapper;
import com.example.appbookselling_quadat.repository.PaymentRepository;
import com.example.appbookselling_quadat.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    @Override
    public List<PaymentResponse> getPaymentList() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream().map(PaymentMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponse getDetailPayment(int id) throws NotFoundException {
        Payment payment = paymentRepository.findPaymentById(id);
        if (Objects.isNull(payment)){
            throw new NotFoundException("Not Found Object in Database");
        }
        return PaymentMapper.convertToResponse(payment);
    }

    @Override
    public void createPayment(Payment obj) {
        Payment payment = paymentRepository.findPaymentByAmount(obj.getAmount());
        if (!Objects.isNull(payment)){
            throw new DuplicateException("Amount exist in Database");
        }
        else {
            paymentRepository.save(obj);
        }
    }

    @Override
    public void updatePayment(Payment obj) {
        Payment payment = paymentRepository.findPaymentByAmount(obj.getAmount());
        if (!Objects.isNull(payment)){
            throw new DuplicateException("Amount exist in Database");
        }
        else {
            paymentRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        Payment payment = paymentRepository.findPaymentById(id);
        if (Objects.isNull(payment)){
            throw new NotFoundException("Not Found Object in Database");
        }
        else {
            paymentRepository.delete(payment);
        }
    }
}
