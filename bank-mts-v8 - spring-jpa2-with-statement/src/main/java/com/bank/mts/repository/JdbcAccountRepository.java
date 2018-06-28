package com.bank.mts.repository;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bank.mts.model.Account;
import com.bank.mts.model.AccountType;

public class JdbcAccountRepository implements AccountRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcAccountRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Account load(String num) {
		String sql = "select * from my_bank.ACCOUNTS where num=?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			Account account = new Account();
			account.setNum(rs.getString(1));
			account.setHolderName(rs.getString(2));
			account.setBalance(rs.getDouble(3));
			account.setType(AccountType.valueOf(rs.getString(4)));
			return account;
		}, num);
	}
	
	
	

	public void update(Account account) {
		String sql = "update my_bank.ACCOUNTS set balance=? where num=?";
		jdbcTemplate.update(sql, account.getBalance(), account.getNum());
	}

}
