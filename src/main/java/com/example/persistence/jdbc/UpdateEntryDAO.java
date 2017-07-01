package com.example.persistence.jdbc;

import org.springframework.stereotype.Repository;
import com.example.AddressBookEntry;

@Repository
public class UpdateEntryDAO extends BaseDAO{
//	private final String QUERY = "insert into ENTRIES(NAME, SURNAME, ADDRESS, PHONE_NUMBER, EMAIL, ZIP) values(?,?,?,?,?,?);";
	private final String QUERY = "update ENTRIES set NAME = ?, SURNAME = ?, ADDRESS = ?, PHONE_NUMBER = ?, EMAIL = ?, ZIP = ? where ID = ?;";

	public void updateEntry(AddressBookEntry entry) {
		this.jdbcTemplate.update(
				QUERY,
				entry.getName(),
				entry.getSurname(),
				entry.getAddress(),
				entry.getPhoneNumber(),
				entry.getEmail(),
				entry.getZip(),
				entry.getId()
				);
	}	
}
