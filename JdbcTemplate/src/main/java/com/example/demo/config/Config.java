package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class Config {

	@Value("${datasource.url}")
	private String datasourceUrl;
	
	@Value("${datasource.username}")
	private String datasourceUsername;
	
	@Value("${datasource.password}")
	private String datasourcePassword;
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(datasourceUrl);
		dataSource.setUsername(datasourceUsername);
		dataSource.setPassword(datasourcePassword);
		dataSource.setConnectionTimeout(1000);
		return dataSource;
	}
}
