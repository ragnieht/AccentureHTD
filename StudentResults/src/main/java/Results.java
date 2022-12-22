

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Results extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_acc_db", "root", "root");
			
			String studentId = req.getParameter("studentId");
			String ps = "select * from student where id = ?";
			PreparedStatement pstmt = con.prepareStatement(ps);
			pstmt.setString(1, studentId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			int id = res.getInt(1);
			String name = res.getString(2);
			int mark1 = res.getInt(3);
			int mark2 = res.getInt(4);
			int mark3 = res.getInt(5);
			
			PrintWriter out = resp.getWriter();
			out.println("Student " + name + " with ID." + id + " marks are " + mark1 + " " + mark2 + " " + mark3);
			System.out.println(id);
			System.out.println(name);
			System.out.println(mark1);
			System.out.println(mark2);
			System.out.println(mark3);
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
