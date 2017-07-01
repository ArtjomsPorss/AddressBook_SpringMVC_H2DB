package com.example.persistence.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.example.AddressBookEntry;

@Repository
public class GetEntryDAO extends BaseDAO{
	
	public List<AddressBookEntry> searchForEntries(AddressBookEntry entry){
		
		Predicate<String> isValue = str -> {
			if(str == null || str == ""){
				return false;
			} else {
				return true;
			}
		};
		
		String query = "select * from ENTRIES ";
		boolean firstValueIsSet = false;
		ArrayList<String> valueList = new ArrayList<>();
		
		if(isValue.test(entry.getName())){
			query += "where NAME like ? ";
			firstValueIsSet = true;
			valueList.add(embraceWithPercentageSigns(entry.getName()));
		}
		if(isValue.test(entry.getSurname())){
			query += firstValueIsSet ? "AND " : "WHERE ";
			query += "SURNAME like ? ";
			firstValueIsSet = true;
			valueList.add(embraceWithPercentageSigns(entry.getSurname()));
		}
		if(isValue.test(entry.getAddress())){
			query += firstValueIsSet ? "AND " : "WHERE ";
			query += "ADDRESS like ? ";
			firstValueIsSet = true;
			valueList.add(embraceWithPercentageSigns(entry.getAddress()));
		}
		if(isValue.test(entry.getPhoneNumber())){
			query += firstValueIsSet ? "AND " : "WHERE ";
			query += "PHONE_NUMBER like ? ";
			firstValueIsSet = true;
			valueList.add(embraceWithPercentageSigns(entry.getPhoneNumber()));
		}
		if(isValue.test(entry.getEmail())){
			query += firstValueIsSet ? "AND " : "WHERE ";
			query += "EMAIL like ? ";
			firstValueIsSet = true;
			valueList.add(embraceWithPercentageSigns(entry.getEmail()));
		}
		if(isValue.test(entry.getZip())){
			query += firstValueIsSet ? "AND " : "WHERE ";
			query += "ZIP like ? ";
			firstValueIsSet = true;
			valueList.add(embraceWithPercentageSigns(entry.getZip()));
		}
		query+=";";
		
		
		return this.jdbcTemplate.query(query, resultSetToEntryMapper, valueList.toArray(new Object[0]));
	}

	
	private String embraceWithPercentageSigns(String parameter) {
		return "%" + parameter + "%";
	}


	public AddressBookEntry getEntryById(int id) {
		String query = "select * from ENTRIES where ID = ? ;";
		List<AddressBookEntry> entries = this.jdbcTemplate.query(query, resultSetToEntryMapper, new Integer(id));
		
		if(!entries.isEmpty()) return entries.get(0);
		
		return new AddressBookEntry();
	}
	
}
