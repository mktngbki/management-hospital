package com.hospital.managementhospital.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserItem implements Serializable {
	private int userId;
	private String user;
	private String pass;

	public UserItem() {
		// TODO Auto-generated constructor stub
	}

	public String getPass() {
		return pass;
	}

	public String getUser() {
		return user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
