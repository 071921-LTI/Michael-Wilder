package com.lntinfotech.models;

public class User {

	private int dlNum;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int accountNum;
	private int routeNum;
	
	
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public User(int dlNum) {
		super();
		this.dlNum = dlNum;
	}
	@Override
	public String toString() {
		return "User [dlNum=" + dlNum + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", accountNum=" + accountNum + ", routeNum=" + routeNum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNum;
		result = prime * result + dlNum;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + routeNum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accountNum != other.accountNum)
			return false;
		if (dlNum != other.dlNum)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (routeNum != other.routeNum)
			return false;
		return true;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int dlNum, String firstName, String lastName, String email, String password, int accountNum,
			int routeNum) {
		super();
		this.dlNum = dlNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accountNum = accountNum;
		this.routeNum = routeNum;
	}
	
	public int getDlNum() {
		return dlNum;
	}
	public void setDlNum(int dlNum) {
		this.dlNum = dlNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getRouteNum() {
		return routeNum;
	}
	public void setRouteNum(int routeNum) {
		this.routeNum = routeNum;
	}
}
