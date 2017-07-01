package com.example.config;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersistenceConfig {
	@Bean // data base connection for DAO files	
	@Scope("singleton")	// not sure is this needed ?
	public DataSource dataSource(){
		final String DB_URL = "jdbc:h2:~/address_book"; // DB file will appear in C:/Users/userName/address_book.mv.db
		final String DB_USER = "";
		final String DB_PASSWORD = "";		
		
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(DB_URL);
		dataSource.setUser(DB_USER);
		dataSource.setPassword(DB_PASSWORD);
		
		return dataSource;
	}
	
	
	
	
	
	
	//TODO destroy tables on application stop and create on start
//	@PostConstruct
//	private void setupDatabase(){
//	}
//	
//	@PreDestroy
//	private void cleanupDatabase(){
//	}
}
