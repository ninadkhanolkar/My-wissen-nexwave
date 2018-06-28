package com.bank.mts.repository;

import java.util.Date;
import java.util.List;

import com.bank.mts.model.Transaction;

public interface TransactionRepository {

	List<Transaction> getTransactions(Date from, Date to);

}