package com.library.card.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.card.domain.Transaction;
import com.library.card.service.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/credit-card/api/v1")
@Api(tags = "Operações com transações via cartão de crédito")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/purchase")
	@ApiOperation(value = "Criar nova transação usando um cartão de crédito")
	public ResponseEntity<Transaction> createTransaction(
			@ApiParam(value = "ID do pedido de compra", required = true)
			@RequestBody String orderId,
			@ApiParam(value = "ID do comprador", required = true)
			@RequestBody String userId,
			@ApiParam(value = "Número do cartão de crédito", required = true)
			@RequestBody String creditCardHolder,
			@ApiParam(value = "Número do cartão de crédito", required = true)
			@RequestBody String creditCardNumber,
			@ApiParam(value = "Expiração do cartão de crédito", required = true)
			@RequestBody String creditCardExpirationDate,
			@ApiParam(value = "Código de segurança do cartão de crédito", required = true)
			@RequestBody String creditCardCVC){
		Transaction transaction = transactionService.create(
				orderId, 
				userId, 
				creditCardHolder, 
				creditCardNumber, 
				creditCardExpirationDate, 
				creditCardCVC);
		return ResponseEntity.created(URI.create(transaction.getId())).body(transaction);
	}
}
