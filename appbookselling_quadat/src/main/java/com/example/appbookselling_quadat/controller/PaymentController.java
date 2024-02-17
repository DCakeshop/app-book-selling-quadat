package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.PaymentResponse;
import com.example.appbookselling_quadat.entity.Payment;
import com.example.appbookselling_quadat.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @GetMapping("/all")
    public List<PaymentResponse> getAllPayment(){
        return paymentService.getPaymentList();
    }

    @GetMapping("/{id}")
    public PaymentResponse getDetailPayment(@PathVariable int id){
        return paymentService.getDetailPayment(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Payment payment){
        paymentService.createPayment(payment);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Payment payment){
        paymentService.updatePayment(payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        paymentService.delete(id);
    }
}
