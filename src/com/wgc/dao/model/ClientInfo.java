package com.wgc.dao.model;

public class ClientInfo {
	private String id;
	private String fullname;
	private String address;
	private String contact;
	private String phone;
	private String bank;
	private String email;
	private String shortname;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	
	public ClientInfo() {
	}
	
	public ClientInfo(String id, String fullname, String address,
			String contact, String phone, String bank, String email,
			String shortname) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.contact = contact;
		this.phone = phone;
		this.bank = bank;
		this.email = email;
		this.shortname = shortname;
	}
}
