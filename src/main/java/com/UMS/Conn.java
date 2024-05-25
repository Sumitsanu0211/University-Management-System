package com.UMS;
import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/universitymanagementSystem", "root", "Sumit@123");
			s = c.createStatement();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
