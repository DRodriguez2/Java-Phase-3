package com.Phase3.SearchingForSpecificUser.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {

	@Id
	private String userID;
	private String firstName;
	private String lastName;

	public UserEntity() {
		
	}
	public UserEntity(String userID, String firstName, String lastName) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	@Override
	public String toString() {
		return userID + ", "  + firstName  + ", " + lastName;
	}
}
