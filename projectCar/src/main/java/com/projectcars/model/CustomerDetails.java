package com.projectcars.model;

public class CustomerDetails {
	private String name;
	private String username;
	private String email;
	
	public CustomerDetails(String username, String name, String email) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerDetail [name=" + name + ", username=" + username + ", email=" + email + "]";
	}	
}
