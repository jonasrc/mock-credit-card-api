package com.library.card.service.implementation;

import org.springframework.stereotype.Service;

import com.library.card.domain.Transaction;
import com.library.card.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Override
	public Transaction create(String orderId, String userId, String creditCardHolder, String creditCardNumber,
			String creditCardExpirationDate, String creditCardCVC) {
		String creditCardLastFour = creditCardNumber.substring(creditCardNumber.length() - 4);
		return new Transaction(orderId, userId, creditCardLastFour);
	}

	
}
