package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.repository.PaymentRepo;

@Service
public class PaymentServiceImpl {
    
    @Autowired
    private PaymentRepo paymentRepo;
    
    public void deletePayment(Long paymentId) {
        paymentRepo.deleteById(paymentId);
    }
}
