package com.bank.mts.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bank.mts.model.Transaction;

public class JpaTransactionRepository implements TransactionRepository {

	@PersistenceContext
	private EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.bank.mts.repository.TransactionRepository#getTransactions(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Transaction> getTransactions(Date from,Date to){
		Query query=entityManager.createQuery("from Transaction t where t.txrId=12");
		//query.setParameter(0, from);
		
		return query.getResultList();
		
	}
}
