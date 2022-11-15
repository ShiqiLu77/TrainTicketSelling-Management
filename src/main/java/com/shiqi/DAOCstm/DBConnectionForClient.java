package com.shiqi.DAOCstm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionForClient {
	
	public DBConnectionForClient() {}
	
	public static Connection connect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DBConnection:Driver not found");
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicketSellings", "client","777647hh");
		} catch (SQLException e) {
			System.out.println("DBConnection:conect failed");
		}
		return con;
	}
}

