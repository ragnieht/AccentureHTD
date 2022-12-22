package com.projectcars.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	private String username;
	private String password;
	private String name;
	private String email;
	
	public Customer(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Connection conDriver() throws SQLException {
		Driver d = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Driver loaded successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db","root","root");
		System.out.println("Connection established successfully");
		return con;
	}	
	
	public boolean validateCustomer(String inputUn, String inputPw) {
		try {				
			Connection con = conDriver();
			String ps = "select * from customer";
			PreparedStatement pstmt = con.prepareStatement(ps);
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {
				while (true) {
					if (res.getString(1) != inputUn) {
						System.out.println("Customer does not exist!");					
					} else if (res.getString(2) != inputPw){
						System.out.println("Wrong password!");
					} else {
						System.out.println("Login success!");
						return true;						
					}
					break;
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean registerCustomer(String inputUn, String inputPw, String inputN, String inputE) {
		try {
			Connection con = conDriver();
			String ps = "insert into customer values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(ps);
			pstmt.setString(1,inputUn);
			pstmt.setString(2,inputPw);
			pstmt.setString(3,inputN);
			pstmt.setString(4,inputE);
			int rows = pstmt.executeUpdate();
			
			if (rows != 0) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
