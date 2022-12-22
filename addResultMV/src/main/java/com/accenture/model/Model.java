package com.accenture.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Model {
	private int id;
	private String name;
	private int mark1;
	private int mark2;
	private int mark3;
	
	public Model(int id, String name, int mark1, int mark2, int mark3) {
		super();
		this.id = id;
		this.name = name;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark1() {
		return mark1;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}

	public int getMark3() {
		return mark3;
	}

	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}
	
	public int addResult() {
		try {
			Driver d = new com.mysql.jdbc.Driver();
    		DriverManager.registerDriver(d);
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_acc_db","root","root");
    		    		     		
    		String ps = "insert into student values (?,?,?,?,?)";
    		PreparedStatement pstmt = con.prepareStatement(ps);
    		
    		pstmt.setInt(1, id);
    		pstmt.setString(2, name);
    		pstmt.setInt(3, mark1);
    		pstmt.setInt(4, mark2);
    		pstmt.setInt(5, mark3);    		
        	int rows = pstmt.executeUpdate();
        	return rows;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
