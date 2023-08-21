package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NotEnoughMoneyException;
import com.example.demo.models.PaymentDetails;

@Service
public class PaymentService {

	public PaymentDetails processPayment() {
		throw new NotEnoughMoneyException();
	}
	
}
