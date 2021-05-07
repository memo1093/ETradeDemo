package entities.concretes;

import entities.abstracts.Entity;

public class User implements Entity{
	int Id;
	String FirstName;
	String LastName;
	String Email;
	String Password;
	boolean Validated;
	public User() {
		
	}
	
	public User(int id, String firstName, String lastName, String email, String password) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
		Validated = false;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	public boolean isValidated() {
		return Validated;
	}

	public void setValidated(boolean validated) {
		Validated = validated;
	}
}
