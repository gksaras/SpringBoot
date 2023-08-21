package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class ProjectConfig {
	
	@Value("${datasource.url}")
	private String dataSourceUrl;

	@Value("${datasource.username}")
	private String dataSourceUsername;
	
	@Value("${datasource.password}")
	private String dataSourcePassword;
	
	@Value("${datasource.driverclassname}")
	private String dataSourceDriverClassname;
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(dataSourceUrl);
		dataSource.setDriverClassName(dataSourceDriverClassname);
		dataSource.setUsername(dataSourceUsername);
		dataSource.setPassword(dataSourcePassword);
		dataSource.setConnectionTimeout(5000);
		return dataSource;
	}
	
}
