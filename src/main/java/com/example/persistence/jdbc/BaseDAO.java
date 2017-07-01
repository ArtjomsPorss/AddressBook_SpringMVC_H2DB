package com.example.persistence.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.AddressBookEntry;

public abstract class BaseDAO {

	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public final RowMapper<AddressBookEntry> resultSetToEntryMapper = (rs, rowNum) ->{
		AddressBookEntry e = new AddressBookEntry();
		e.setId(rs.getInt("id"));
	    e.setName(rs.getString("name"));
	    e.setSurname(rs.getString("surname"));
	    e.setAddress(rs.getString("address"));
	    e.setPhoneNumber(rs.getString("phone_number"));
	    e.setEmail(rs.getString("email"));
	    e.setZip(rs.getString("zip"));
	    
	    return e;
	};
}
