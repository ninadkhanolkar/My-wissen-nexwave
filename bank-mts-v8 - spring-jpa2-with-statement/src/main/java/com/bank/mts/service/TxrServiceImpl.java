package com.bank.mts.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bank.mts.model.Account;
import com.bank.mts.model.Status;
import com.bank.mts.model.Transaction;
import com.bank.mts.model.TransactionType;
import com.bank.mts.repository.AccountRepository;

public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	public TxrServiceImpl() {
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
			List<Transaction> transactions=fromAccount.getTransactions();
			transactions.add(fromAccountTransaction);
			
			Transaction toAccountTransaction=new Transaction(new Date(), TransactionType.CREDIT, amount, toAccountClosingBalance, "credit", Status.SUCCESS);
			transactions=toAccount.getTransactions();
			transactions.add(toAccountTransaction);

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

}
