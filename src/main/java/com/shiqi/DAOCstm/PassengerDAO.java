package com.shiqi.DAOCstm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shiqi.pojo.Client;
import com.shiqi.pojo.Passenger;

public class PassengerDAO {
	
	public PassengerDAO() {
		
	}
	
	public static void createNewPassenger(Passenger p) {
		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("INSERT INTO `Passenger` (`PID`, `firstName`, `lastName`) VALUES (?, ?, ?);",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, p.getPid());
			pstmt.setString(2, p.getFname());
			pstmt.setString(3, p.getLname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Some errors in creating new passenger");
			e.printStackTrace();
		}
	}
	
	public static void savePassengerUnderClient(Client c, Passenger p) {
		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("INSERT INTO `client_btf_psgs` (`cid`, `pid`) VALUES (?, ?);",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, c.getCid());
			pstmt.setString(2, p.getPid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Some errors in saving the new passenger under the client");
			e.printStackTrace();
		}
	}
	
	public static void deletePassengerFromClient(Client c, Passenger p) {

		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("DELETE FROM `TicketSellings`.`client_btf_psgs` WHERE `cid`=? and `pid` = ? ;",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, c.getCid());
			pstmt.setString(2, p.getPid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Some errors in deleting the passenger from the client");
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Passenger> getPassengers(Client c) {
		ArrayList<Passenger> psgs = new ArrayList<Passenger>();
		Connection con = DBConnectionForClient.connect();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("SELECT * from `psgUnderClient` where `cid` = ?",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, c.getCid());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Passenger p = new Passenger(rs.getString("pid"), rs.getString("firstname"), rs.getString("lastname"));
				psgs.add(p);
			}
			return psgs;
		} catch (SQLException e) {
			System.out.println("Some false in get passengers");
			return psgs;
		}
	}
}
