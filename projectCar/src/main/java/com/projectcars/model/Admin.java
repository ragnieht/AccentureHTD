package com.projectcars.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
	private String username;
	private String password;
	
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection conDriver() throws SQLException {
		Driver d = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Driver loaded successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_db","root","root");
		System.out.println("Connection established successfully");
		return con;
	}
	
	public String validateAdmin() {
		try {				
			Connection con = conDriver();
			String ps = "select * from admin";
			PreparedStatement pstmt = con.prepareStatement(ps);
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {
				while (true) {
//					System.out.println(res.getString(1) + " " + username);
					if (!res.getString(1).equals(username)) {
						System.out.println("Admin does not exist!");
						return "invalidUn";
					} else if (!res.getString(2).equals(password)){
						System.out.println("Wrong password!");
						return "invalidPw";
					} else {
						System.out.println("Login success!");
						return "success";						
					}
//					break;
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error";		
	}
}