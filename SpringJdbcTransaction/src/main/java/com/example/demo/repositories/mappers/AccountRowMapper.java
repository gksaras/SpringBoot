package com.example.demo.repositories.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Account;

public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account acc = new Account();
		acc.setId(rs.getInt("id"));
		acc.setName(rs.getString("name"));
		acc.setAmount(rs.getBigDecimal("amount"));	
		return acc;
	}
	
}
