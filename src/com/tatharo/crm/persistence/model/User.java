package com.tatharo.crm.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@Column(name = "USER_ID")
	private long id;
	@Column(name = "USERNAME")
	private String userName;

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
