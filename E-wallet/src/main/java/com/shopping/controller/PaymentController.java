package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.models.PaymentDetails;
import com.shopping.service.PaymentService;
@RestController
@RequestMapping("/dopay")
public class PaymentController {
	@Autowired
    public PaymentService service;

    @PostMapping("/payment")
    public PaymentDetails doPayment(@RequestBody PaymentDetails payment){
        return service.doPay(payment);
    }

}
