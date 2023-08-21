package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TransferRequest;
import com.example.demo.model.Account;
import com.example.demo.service.TransferService;

@RestController
public class AccountController {

	private final TransferService transferService;
	
	public AccountController(TransferService transferService) {
		this.transferService = transferService;
	}
	
	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferRequest transferRequest) {
		transferService.transferMoney(transferRequest.getSenderAccountId(),
				transferRequest.getReceiverAccountId(),
				transferRequest.getAmount());
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts(){
		return transferService.getAllAccounts();
	}
}
