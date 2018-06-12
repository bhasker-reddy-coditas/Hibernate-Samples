package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbc_url ="jdbc:mysql://localhost:3306/dev01?useSSL=false";
		String user = "devuser";
		String pwd ="1234";
	try {
		System.out.println("Connecting to : "+jdbc_url);
		Connection conn =  DriverManager.getConnection(jdbc_url, user, pwd);
		System.out.println("connection successful!! "+conn);
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

}
