package com.shiqi.DAOMng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.shiqi.pojo.Manager;

public class DBConnectionForManager {
	
public DBConnectionForManager() {}
    private String username;
    private String password;
	
	public DBConnectionForManager(Manager m) {
		super();
		this.username = m.getUsername();
		this.password = m.getPassword();
	}

	public Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DBConnection:Driver not found");
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicketSellings", username, password);
		} catch (SQLException e) {
			System.out.println("DBConnection:conect failed");
		}
		return con;
	}

}
