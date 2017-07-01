package com.example.persistence;

import java.util.List;

import com.example.AddressBookEntry;

public interface AddressBookRepository {
	
	public List<AddressBookEntry> getAllEntries();

	public void addEntry(AddressBookEntry entry);

	public List<AddressBookEntry> searchForEntry(AddressBookEntry addressBookEntry);

	public void deleteEntry(int id);

	public AddressBookEntry getEntryById(int id);

	public void updateEntry(AddressBookEntry entry);
}
