package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AddressBookEntry;
import com.example.persistence.AddressBookRepository;

@Service
public class ApplicationService {
	
	@Autowired
	private AddressBookRepository addressBookRepo;
	
	public List<AddressBookEntry> getAllEntries(){
		return addressBookRepo.getAllEntries();
	}

	public void addEntry(AddressBookEntry entry) {
		addressBookRepo.addEntry(entry);		
	}

	public List<AddressBookEntry> searchForEntry(AddressBookEntry addressBookEntry) {
		return addressBookRepo.searchForEntry(addressBookEntry);
	}

	public void deleteEntry(int id) {
		addressBookRepo.deleteEntry(id);
	}

	public AddressBookEntry getEntryById(int id) {
		return addressBookRepo.getEntryById(id);
	}

	public void updateEntry(AddressBookEntry entry) {
		addressBookRepo.updateEntry(entry);		
	}
	
}
