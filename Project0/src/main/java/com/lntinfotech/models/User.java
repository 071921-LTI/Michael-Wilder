package com.lntinfotech.models;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private User user;
	private boolean toString1;
	
	
	
	public boolean isToString1() {
		return toString1;
	}
	public void setToString1(boolean toString1) {
		this.toString1 = toString1;
	}
	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public User(String email) {
		super();
		this.email = email;
	}
	public User(int userId) {
		super();
		this.userId = userId;
	}
	

	@Override
	public String toString() {
		return "User userId = " + userId + " " + (firstName != null ? "firstName = " + firstName + " " : "")
				+ (lastName != null ? "lastName = " + lastName + " " : "")
				+ (email != null ? "email = " + email + " " : "")
				+ (password != null ? "password = " + password + " " : "") + (user != null ? "user = " + user : "") + "";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		if (userId != other.userId)
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
		return true;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String firstName, String lastName, String email, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public User(int userId, String firstName, String lastName, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public User(int userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	
}
