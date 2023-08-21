package com.example.demo.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Payment;
import com.example.demo.proxy.PaymentsProxy;

public class PaymentController {

	private final PaymentsProxy paymentsProxy;

	  public PaymentController(PaymentsProxy paymentsProxy) {
	    this.paymentsProxy = paymentsProxy;
	  }

	  @PostMapping("/payment")
	  public Payment createPayment(@RequestBody Payment payment) {
	    String requestId = UUID.randomUUID().toString();
	    return paymentsProxy.createPayment(requestId, payment);
	  }
}