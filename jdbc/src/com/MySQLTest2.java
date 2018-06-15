package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLTest2 {
	public static void main(String[] args) {
		try {
			//load driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("--Driver class loaded successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
			System.out.println("--Connection Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
