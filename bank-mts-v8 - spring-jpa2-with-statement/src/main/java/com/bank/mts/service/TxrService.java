package com.bank.mts.service;

import com.bank.mts.repository.AccountRepository;

public interface TxrService {
	public void setAccountRepository(AccountRepository accountRepository);
	void txr(double amount, String fromAccNum, String toAccNum);
}
