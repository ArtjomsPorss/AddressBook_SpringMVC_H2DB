package com.example.persistence.jdbc;

import org.springframework.stereotype.Repository;
import com.example.AddressBookEntry;

@Repository
public class DeleteEntryDAO extends BaseDAO{
	private final String QUERY = "DELETE from ENTRIES where ID = ?;";
	
	public int  deleteEntry(int id){
		return this.jdbcTemplate.update(QUERY, id);
	}	
}
