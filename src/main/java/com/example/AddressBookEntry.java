package com.example;

public class AddressBookEntry {
	
	int id;
	private String name;
	private String surname;
	private String address;
	private String phoneNumber;
	private String email;
	private String zip;
	
	public AddressBookEntry(){}
	
	public AddressBookEntry(int id, String name, String surname, String address, String phoneNumber,
			String email, String zip) {
		super();
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
		this.setZip(zip);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name.toUpperCase();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname.toUpperCase();
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address.toUpperCase();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber.toUpperCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toUpperCase();
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip.toUpperCase();
	}

	@Override
	public String toString() {
		return  
				"Name:" + name + "\n" +
				"Surname:" + surname + "\n" +
				"Address:" + address + "\n" +
				"Phone Number:" + phoneNumber + "\n"+
				"email:" + email + "\n" +
				"zip:" + zip;
	}	
}
