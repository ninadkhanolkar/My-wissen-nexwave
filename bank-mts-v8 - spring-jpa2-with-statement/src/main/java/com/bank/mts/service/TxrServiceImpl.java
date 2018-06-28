package com.bank.mts.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bank.mts.model.Account;
import com.bank.mts.model.Status;
import com.bank.mts.model.Transaction;
import com.bank.mts.model.TransactionType;
import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.TransactionRepository;

public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;
	private TransactionRepository transactionRepository;

	public TxrServiceImpl() {
	}
	
	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository=transactionRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional
	public void txr(double amount, String fromAccNum, String toAccNum) {
		try {

			Account fromAccount = accountRepository.load(fromAccNum);
			Account toAccount = accountRepository.load(toAccNum);
			double fromAccountClosingBalance=fromAccount.getBalance() - amount;
			double toAccountClosingBalance=toAccount.getBalance() + amount;
			fromAccount.setBalance(fromAccountClosingBalance);
			toAccount.setBalance(toAccountClosingBalance);
			Transaction fromAccountTransaction=new Transaction(new Date(), TransactionType.DEBIT, amount, fromAccountClosingBalance, "debit", Status.SUCCESS);
			fromAccountTransaction.setAccount(fromAccount);
			List<Transaction> transactions=fromAccount.getTransactions();
			transactions.add(fromAccountTransaction);
			fromAccount.setTransactions(transactions);
			
			Transaction toAccountTransaction=new Transaction(new Date(), TransactionType.CREDIT, amount, toAccountClosingBalance, "credit", Status.SUCCESS);
			toAccountTransaction.setAccount(toAccount);
			transactions=toAccount.getTransactions();
			transactions.add(toAccountTransaction);
			toAccount.setTransactions(transactions);

			accountRepository.update(fromAccount);
			
//			boolean b = false;
//			if (b)
//				throw new RuntimeException();
			accountRepository.update(toAccount);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Transaction> viewTransactions(Date from, Date to) {
		// TODO Auto-generated method stub
		return transactionRepository.getTransactions(from, to);
		
	}

}
