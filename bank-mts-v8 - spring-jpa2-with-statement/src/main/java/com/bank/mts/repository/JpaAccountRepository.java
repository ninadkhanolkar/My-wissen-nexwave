package com.bank.mts.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bank.mts.model.Account;
import com.bank.mts.model.Transaction;

public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Account load(String num) {
		return entityManager.find(Account.class, num);
	}

	@Override
	public void update(Account account) {
		
		entityManager.merge(account);
	}

}
