package com.bank.mts.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transactions",schema="my_bank")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int txrId;
	@ManyToOne
	@JoinColumn(name="num")
	Account account;
	@Temporal(TemporalType.DATE)
	@Column(name="txrDate")
	private Date date;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	private double amount;
	private double closingAmount;
	private String description;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	public Transaction( Date date, TransactionType type, double amount, double closingAmount, String description,
			Status status) {
		super();
	
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.closingAmount = closingAmount;
		this.description = description;
		this.status = status;
	}

	public int getTxrId() {
		return txrId;
	}

	public void setTxrId(int txrId) {
		this.txrId = txrId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getClosingAmount() {
		return closingAmount;
	}

	public void setClosingAmount(double closingAmount) {
		this.closingAmount = closingAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Transaction [txrId=" + txrId + ", account=" + account + ", date=" + date + ", type=" + type
				+ ", amount=" + amount + ", closingAmount=" + closingAmount + ", description=" + description
				+ ", status=" + status + "]";
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	

}
