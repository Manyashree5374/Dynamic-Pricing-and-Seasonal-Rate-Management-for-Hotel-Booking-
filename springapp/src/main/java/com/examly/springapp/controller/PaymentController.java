package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.repository.PaymentRepo;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentRepo pay;

    @DeleteMapping("/{paymentId}")
    public String deleteroom(@PathVariable Long paymentId){
        pay.deleteById(paymentId);
        return "user deleted";
    } 
}
