package com.projectzero.model;

import java.util.List;
import java.util.Objects;

public class User {
	
	/**
	 * 
	 * User Info fields
	 */
	private int id;
	private String username;
	private String email;
	private String password;	
	private String type;

	/**
	 * Personal Info fields
	 */
	private String fristName;
	private String lastName;
	private String address;
	private String dob;
	private String phone;
	private String ssn;
	
	/**
	 * Account Info fields
	 */
	private List<Account> accounts;
	
	/**
	 * @param id
	 * @param username
	 * @param email
	 * @param password
	 * @param type
	 * @param fristName
	 * @param lastName
	 * @param address
	 * @param dob
	 * @param phone
	 * @param ssn
	 * @param accounts
	 */
	public User(int id, String username, String email, String password, String type, String fristName, String lastName,
			String address, String dob, String phone, String ssn, List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.type = type;
		this.fristName = fristName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
		this.phone = phone;
		this.ssn = ssn;
		this.accounts = accounts;
	}


	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(accounts, address, dob, email, fristName, id, lastName, password, phone, ssn, type,
				username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(accounts, other.accounts) && Objects.equals(address, other.address)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(fristName, other.fristName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(ssn, other.ssn)
				&& Objects.equals(type, other.type) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", type="
				+ type + ", fristName=" + fristName + ", lastName=" + lastName + ", address=" + address + ", dob=" + dob
				+ ", phone=" + phone + ", ssn=" + ssn + ", accounts=" + accounts + "]";
	}

	
}
