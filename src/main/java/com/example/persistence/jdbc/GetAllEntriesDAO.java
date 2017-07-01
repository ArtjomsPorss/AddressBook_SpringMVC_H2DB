package com.example.persistence.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.AddressBookEntry;

@Repository
public class GetAllEntriesDAO extends BaseDAO{
	private final String QUERY = "select * from ENTRIES order by ID";
	
	public List<AddressBookEntry> getAllEntries(){
		return this.jdbcTemplate.query(QUERY, resultSetToEntryMapper);
	}
	
}
