package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OracleTest {
	public static void main(String[] args) {
		try {
			//load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("--Driver class loaded successfully");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ninad", "tiger");
			System.out.println("--Connection Success");
			Statement stmt=con.createStatement();
			String qry="insert into employee values(1,'Praveen',15000)";
			int x=stmt.executeUpdate(qry);
			System.out.println(x+" Records inserted");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
