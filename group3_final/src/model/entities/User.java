package model.entities;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String FIRSTNAME = "NO FIRSTNAME";
	public static final String LASTNAME = "NO LASTNAME";
	public static final String EMAIL = "NO EMAIL";
	public static final String PASSWORD = "NO PASSWORD";
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	
	
	public User() {
		this(User.PASSWORD, User.FIRSTNAME, User.LASTNAME);
	}

	public User( String password, String firstName, String lastName) {
		
		this.email = lastName.toLowerCase() + firstName.toLowerCase() + "@gmail.com";
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
