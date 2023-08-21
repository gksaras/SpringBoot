package com.example.demo.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Purchase;

@Repository
public class PurchaseRepository {

private final JdbcTemplate jdbc;
	
	public PurchaseRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@PostMapping
	public void storePurchase(@RequestBody Purchase purchase) {
		String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";
		jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
	}
	
	public List<Purchase> findAllPurchases() {
		String sql = "SELECT * FROM purchase";
		
			RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
			Purchase rowObject = new Purchase();
			rowObject.setId(r.getInt("id"));
			rowObject.setProduct(r.getString("product"));
			rowObject.setPrice(r.getBigDecimal("price"));
			return rowObject;
		};
		
		return jdbc.query(sql, purchaseRowMapper);
	}
	
}
