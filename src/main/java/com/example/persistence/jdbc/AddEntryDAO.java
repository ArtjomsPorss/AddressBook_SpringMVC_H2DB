package com.example.persistence.jdbc;

import org.springframework.stereotype.Repository;
import com.example.AddressBookEntry;

@Repository
public class AddEntryDAO extends BaseDAO{
	private final String QUERY = "insert into ENTRIES(NAME, SURNAME, ADDRESS, PHONE_NUMBER, EMAIL, ZIP) values(?,?,?,?,?,?);";
	
	public void addEntry(AddressBookEntry entry){
		this.jdbcTemplate.update(
				QUERY, 
				entry.getName(),
				entry.getSurname(),
				entry.getAddress(),
				entry.getPhoneNumber(),
				entry.getEmail(),
				entry.getZip());
	}	
}
