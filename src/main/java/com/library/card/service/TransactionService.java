package com.library.card.service;

import com.library.card.domain.Transaction;

public interface TransactionService {
	public Transaction create(
			String orderId, 
			String userId, 
			String creditCardHolder, 
			String creditCardNumber, 
			String creditCardExpirationDate, 
			String creditCardCVC);
}
