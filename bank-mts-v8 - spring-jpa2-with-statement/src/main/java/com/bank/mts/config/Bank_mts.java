package com.bank.mts.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.bank.mts.model.Transaction;
import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.JpaAccountRepository;
import com.bank.mts.repository.JpaTransactionRepository;
import com.bank.mts.repository.TransactionRepository;
import com.bank.mts.service.TxrService;
import com.bank.mts.service.TxrServiceImpl;

@Configuration
@Import(value = { Bank_infra.class })
@ComponentScan(basePackages = { "com.bank.mts" })
public class Bank_mts {

	@Bean
	public AccountRepository accountRepositoery() {
		AccountRepository accountRepository = new JpaAccountRepository();
		return accountRepository;
	}
	
	@Bean
	public TransactionRepository transactionRepository() {
		TransactionRepository transactionRepository=new JpaTransactionRepository();
		return transactionRepository;
	}

	@Bean
	public TxrService txrService() {
		TxrService txrService = new TxrServiceImpl();
		txrService.setAccountRepository(accountRepositoery());
		txrService.setTransactionRepository(transactionRepository());
		return txrService;
	}

}
