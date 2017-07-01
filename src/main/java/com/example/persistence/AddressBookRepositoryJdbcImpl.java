package com.example.persistence;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.AddressBookEntry;
import com.example.persistence.jdbc.AddEntryDAO;
import com.example.persistence.jdbc.DeleteEntryDAO;
import com.example.persistence.jdbc.GetAllEntriesDAO;
import com.example.persistence.jdbc.GetEntryDAO;
import com.example.persistence.jdbc.UpdateEntryDAO;

@Repository
public class AddressBookRepositoryJdbcImpl implements AddressBookRepository {
	
	protected JdbcTemplate jdbcTemplate;	
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private GetAllEntriesDAO getAllEntriesDAO;
	@Autowired
	private AddEntryDAO addEntryDAO;
	@Autowired
	private GetEntryDAO getEntryDAO;
	@Autowired
	private DeleteEntryDAO deleteEntryDAO;
	@Autowired
	private UpdateEntryDAO updateEntryDAO;
	

	@Override
	public List<AddressBookEntry> getAllEntries(){
		return getAllEntriesDAO.getAllEntries();
	}

	@Override
	public void addEntry(AddressBookEntry entry) {
		addEntryDAO.addEntry(entry);
		
	}

	@Override
	public List<AddressBookEntry> searchForEntry(AddressBookEntry entry) {
		return getEntryDAO.searchForEntries(entry);
	}

	@Override
	public void deleteEntry(int id) {
		int result = deleteEntryDAO.deleteEntry(id);		
	}

	@Override
	public AddressBookEntry getEntryById(int id) {
		return getEntryDAO.getEntryById(id);
	}

	@Override
	public void updateEntry(AddressBookEntry entry) {
		updateEntryDAO.updateEntry(entry);
	}
	
}
