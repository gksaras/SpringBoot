package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;
import com.example.demo.repositories.mappers.AccountRowMapper;

@Repository
public class AccountRepository {

	private final JdbcTemplate jdbc;
	
	public AccountRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public Account findAccountById(long id) {
		String sql = "select*from account where id=?";
		return jdbc.queryForObject(sql, new AccountRowMapper(),id);
	}
	
	public List<Account> findAllAccounts(){
		String sql = "select * from account";
		return  jdbc.query(sql, new AccountRowMapper());
	}
	
	public void changeAmount(int id,BigDecimal amount) {
		String sql = "update account set amount=? where id=?";
		jdbc.update(sql,amount,id);
	}
}
