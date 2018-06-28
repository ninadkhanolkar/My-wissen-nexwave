package com.bank.mts.service;

import java.util.Date;
import java.util.List;

import com.bank.mts.model.Transaction;
import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.TransactionRepository;

public interface TxrService {
	public void setAccountRepository(AccountRepository accountRepository);
	public void setTransactionRepository(TransactionRepository transactionRepository);
	void txr(double amount, String fromAccNum, String toAccNum);
	List<Transaction> viewTransactions(Date from,Date to);
}
