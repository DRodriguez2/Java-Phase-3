package com.Phase3.ImplementSpringSecurity.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String userID;
	private String password;
	
	public User() {}
	
	public User(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "UserEntity [userID=" + userID + ", password=" + password + "]";
	}
	
	
	
}


