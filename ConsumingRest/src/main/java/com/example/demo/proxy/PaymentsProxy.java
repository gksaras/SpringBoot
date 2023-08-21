package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.demo.model.Payment;

@FeignClient(name="payments", url= "${name.service.url}") 
public interface PaymentsProxy {

	@PostMapping("/payment")	// Specify the endpoints path and HTTP method
	Payment createPayment(
			@RequestHeader String requestId,	// Define the request headers and body.
			@RequestBody Payment payment);
}
