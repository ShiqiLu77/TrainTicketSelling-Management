package com.shiqi.DAOCstm;

import java.lang.invoke.VarHandle;
import java.security.DrbgParameters.NextBytes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.util.DnsSrv.SrvRecord;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Passenger;

public class ClientDAO {

	public ClientDAO() {

	}

	public static boolean chectClientExist(String username) {
		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("call checkClientExsit(?)", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			System.out.println("Some errors in checking client exsitance");
			e.printStackTrace();
			return true;
		}
	}

	public static void createClient(String username, String password) {
		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("call createClient(?,?)", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Some errors in register client");
			e.printStackTrace();
		}
	}

	public static Client getClient(String cid) {
		String id = cid;

		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("SELECT * from `Client` WHERE `CID` = ?;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return (new Client(rs.getString("cid"), rs.getString("username"), rs.getString("password"),
					rs.getString("phone"), rs.getString("email")));

		} catch (SQLException e) {
			System.out.println("Some errors in getting client");
			e.printStackTrace();
			return null;
		}
	}

	public static void updateInfo(String cid, String phone, String email) {
		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(
					"UPDATE `TicketSellings`.`Client` SET `phone` = ?, `email` = ? WHERE (`CID` = ?);",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, phone);
			pstmt.setString(2, email);
			pstmt.setString(3, cid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Some errors in updaing client info");
			e.printStackTrace();
		}

	}

	public static Client Login(String username, String password) {
		Client c = null;
		String un = username;
		String pw = password;

		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("SELECT * from `client` where `username` = ? and `password` = ?",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new Client(rs.getString("cid"), rs.getString("username"), rs.getString("password"),
						rs.getString("phone"), rs.getString("email"));
			}
			return c;
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Some errors in logging in");
			return c;
		}
	}
}