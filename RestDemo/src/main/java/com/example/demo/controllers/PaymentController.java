
package com.example.demo.controllers;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.exceptions.NotEnoughMoneyException;
//import com.example.demo.models.ErrorDetails;
import com.example.demo.models.PaymentDetails;
//import com.example.demo.services.PaymentService;

//@RestController
//public class PaymentController {

//	private final PaymentService paymentService;
//	
//	public PaymentController(PaymentService paymentService) {
//
//		this.paymentService = paymentService;
//	}
	
	// Rest endpoint exception handling without AOP Advice
//	@PostMapping("/payment")
//	public ResponseEntity<?> makePayment(){
//		try {
//			PaymentDetails paymentDetails = paymentService.processPayment();
//			return ResponseEntity
//					.status(HttpStatus.ACCEPTED)
//					.body(paymentDetails);
//		} catch(NotEnoughMoneyException e) {
//			ErrorDetails errorDetails = new ErrorDetails();
//			errorDetails.setMessage("Not Enough Money To Make Payment");
//			return ResponseEntity
//					.badRequest()
//					.body(errorDetails);
//		}
//	}
	
	// Rest endpoint exception handling with AOP Advice
	
//	private static Logger logger = Logger.getLogger(PaymentController.class.getName());
//	
//	@PostMapping("/payment")
//	public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails){
//		//PaymentDetails paymentDetails = paymentService.processPayment();
//		logger.info("Received Payment :"+paymentDetails.getAmount());
//		return ResponseEntity
//				.status(HttpStatus.ACCEPTED)
//				.body(paymentDetails);
//		
//	}
//}
@RestController
public class PaymentController {

  private static Logger logger =
      Logger.getLogger(PaymentController.class.getName());

  @PostMapping("/payment")
  public ResponseEntity<PaymentDetails> makePayment(
      @RequestBody PaymentDetails paymentDetails) {
	  
      logger.info("Received payment " + paymentDetails.getAmount());
      
      return ResponseEntity
              .status(HttpStatus.ACCEPTED)
              .body(paymentDetails);
  }
}
