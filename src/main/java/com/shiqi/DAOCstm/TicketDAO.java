package com.shiqi.DAOCstm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shiqi.pojo.Ticket;

public class TicketDAO {
	
	
	public static ArrayList<Ticket> myUnusedTickets(String cid) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Connection con = DBConnectionForClient.connect();
		try {
				PreparedStatement pstmt = con.prepareStatement("Call myUnusedTickets(?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1, cid);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Ticket t = new Ticket(rs.getString("ticket number"),rs.getString("passenger ID"),
							rs.getString("passenger"),rs.getString("date"),rs.getString("train id"),
							rs.getString("carriage"),rs.getString("row"),rs.getString("column"),
							rs.getString("seat type"),rs.getString("from city"),rs.getString("to city"),
							rs.getString("from station"),rs.getString("to station"),
							rs.getString("leave time"),rs.getString("arrive time"),
							rs.getString("duration"),rs.getString("price"),rs.getString("status"),
							rs.getString("seatID")
							);
					tickets.add(t);
				}
				return tickets;
		} catch (SQLException e) {
			System.out.println("Some error in unpaying ticket");
			e.printStackTrace();
			return tickets;
		}
	}
	
	public static ArrayList<Ticket> myUsedTickets(String cid) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Connection con = DBConnectionForClient.connect();
		try {
				PreparedStatement pstmt = con.prepareStatement("Call myUsedTickets(?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1, cid);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Ticket t = new Ticket(rs.getString("ticket number"),rs.getString("passenger ID"),
							rs.getString("passenger"),rs.getString("date"),rs.getString("train id"),
							rs.getString("carriage"),rs.getString("row"),rs.getString("column"),
							rs.getString("seat type"),rs.getString("from city"),rs.getString("to city"),
							rs.getString("from station"),rs.getString("to station"),
							rs.getString("leave time"),rs.getString("arrive time"),
							rs.getString("duration"),rs.getString("price"),rs.getString("status"),
							rs.getString("seatID")
							);
					tickets.add(t);
				}
				return tickets;
		} catch (SQLException e) {
			System.out.println("Some error in unpaying ticket");
			e.printStackTrace();
			return tickets;
		}
	}
	
	public static void unpayTicket(ArrayList<Ticket> tickets) {
		Connection con = DBConnectionForClient.connect();
		try {
			for (Ticket t : tickets) {
				PreparedStatement pstmt = con.prepareStatement("Call unpayTicket(?,?)",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1, t.getTicketNumberString());
				pstmt.setString(2, t.getSeatID());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Some error in unpaying ticket");
			e.printStackTrace();
		}
	}
	
	public static void payTicket(String cid, String datetime, ArrayList<Ticket> tickets) {
		Connection con = DBConnectionForClient.connect();
		try {
			for (Ticket t : tickets) {
				PreparedStatement pstmt = con.prepareStatement("Call payTicket(?,?,?)",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1, cid);
				pstmt.setString(2, datetime);
				pstmt.setString(3, t.getTicketNumberString());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Some error in paying ticket");
			e.printStackTrace();
		}
	}

	public static Ticket generateTicket(String pid, String ftpsid, String ttpsid, String seatid) {
		Connection con = DBConnectionForClient.connect();
		Ticket ticket = null;
		try {
			PreparedStatement pstmt1 = con.prepareStatement("Call generateTicket(?,?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pstmt1.setString(1, pid);
			pstmt1.setString(2, ftpsid);
			pstmt1.setString(3, ttpsid);
			pstmt1.setString(4, seatid);

			ResultSet rs = pstmt1.executeQuery();
			while (rs.next()) {
				ticket = new Ticket(rs.getString("ticket number"),rs.getString("passenger ID"),
						rs.getString("passenger"),rs.getString("date"),rs.getString("train id"),
						rs.getString("carriage"),rs.getString("row"),rs.getString("column"),
						rs.getString("seat type"),rs.getString("from city"),rs.getString("to city"),
						rs.getString("from station"),rs.getString("to station"),
						rs.getString("leave time"),rs.getString("arrive time"),
						rs.getString("duration"),rs.getString("price"),rs.getString("status"),
						rs.getString("seatID")
						);
			}
			return ticket;
		} catch (SQLException e) {
			System.out.println("Some error in getting tickets");
			e.printStackTrace();
			return ticket;
		}
	}
		
}
