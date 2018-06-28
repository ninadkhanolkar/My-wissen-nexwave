package com.bank.mts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="ACCOUNTS",schema="my_bank")
public class Account {

	@Id
	@Column(name="num")
	private String num;
	@Column(name="name")
	private String holderName;
	@Column(name="balance")
	private double balance;
	@Enumerated(EnumType.STRING)
	private AccountType type;
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
   // @JoinColumn(name="txrId")
	@OneToMany(mappedBy="account",cascade=CascadeType.ALL)
	List<Transaction> transactions;
	

	public Account() {
		// TODO Auto-generated constructor stub
	}
	public List<Transaction> getTransactions() {
		if(transactions!=null)
		return transactions;
		else
			return new ArrayList<>();
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

}
