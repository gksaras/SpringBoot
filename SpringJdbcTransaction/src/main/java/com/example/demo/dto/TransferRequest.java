package com.example.demo.dto;

import java.math.BigDecimal;

// DTO => Data Transfer Object
public class TransferRequest {

	private int senderAccountId;
	private int receiverAccountId;
	private BigDecimal amount;
	
	public int getSenderAccountId() {
		return senderAccountId;
	}
	public void setSenderAccountId(int senderAccountId) {
		this.senderAccountId = senderAccountId;
	}
	public int getReceiverAccountId() {
		return receiverAccountId;
	}
	public void setReceiverAccountId(int receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
