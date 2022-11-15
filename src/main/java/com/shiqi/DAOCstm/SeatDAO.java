package com.shiqi.DAOCstm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.conf.StringProperty;
import com.shiqi.pojo.Seat;

public class SeatDAO {

	public SeatDAO() {
	}

	public static ArrayList<Seat> getPreferredSeat(String date, String trainID, String seattype, int limit, ArrayList<String> locations) {
		ArrayList<Seat> seats = new ArrayList<Seat>();
		Connection con = DBConnectionForClient.connect();
		
		System.out.println(locations);
		String location = "";
		for (String s : locations) {
			System.out.println("com " + s);
			location += "\"" + s + "\",";
			System.out.println("location turns to " + location);
		}
		location = location.substring(0, location.length() - 1);
		System.out.println(location);
		
		String stmt = ("SELECT * FROM TicketSellings.`seat detail` "
				+ "where `status` = 'Y' and `date` = ? and `train id` = ?  and `seat type` = ?"
				+ "and `column` in (" + location + ") order by `carriage`,`row` limit ?;");
		try {
			PreparedStatement pstmt = con.prepareStatement(stmt, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, date);
			pstmt.setString(2, trainID);
			pstmt.setString(3, seattype);
			pstmt.setInt(4, limit);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Seat s = new Seat(rs.getString("seatid"), rs.getString("date"), rs.getString("train id"),
						rs.getString("carriage"), rs.getString("row"), rs.getString("column"), 
						rs.getString("seat type"), rs.getString("seat price base"), rs.getString("status"));
				seats.add(s);
			}
			return seats;
		} catch (SQLException e) {
			System.out.println("Some error in getting preferred seats");
			e.printStackTrace();
			return seats;
		}
	}

	public static ArrayList<Seat> getSeat(String date, String trainID,String seattype, int limit) {
		ArrayList<Seat> seats = new ArrayList<Seat>();
		Connection con = DBConnectionForClient.connect();

		try {
			PreparedStatement pstmt = con.prepareStatement("Call getSeat(?,?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, date);
			pstmt.setString(2, trainID);
			pstmt.setString(3, seattype);
			pstmt.setInt(4, limit);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Seat s = new Seat(rs.getString("seatid"), rs.getString("date"), rs.getString("train id"),
						rs.getString("carriage"), rs.getString("row"), rs.getString("column"),
						rs.getString("seat type"), rs.getString("seat price base"), rs.getString("status"));
				seats.add(s);
			}
			return seats;
		} catch (SQLException e) {
			System.out.println("Some error in getting seats");
			return seats;
		}
	}
	
	public static ArrayList<String[]> getAvailableSeatTypeCountAndPrice(String date, String trainID) {
		ArrayList<String[]> seatTypeAndCount = new ArrayList<String[]>();
		Connection con = DBConnectionForClient.connect();

		try {
			PreparedStatement pstmt = con.prepareStatement("Call AvailableSeatTypeCountAndPrice(?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, date);
			pstmt.setString(2, trainID);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] typeAndCount = new String[3];
				typeAndCount[0] = rs.getString("seat type");
				typeAndCount[1] = rs.getString("count");
				typeAndCount[2] = rs.getString("price base");
				seatTypeAndCount.add(typeAndCount);
			}
			return seatTypeAndCount;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Some error in getting available seat type and its count");
			return seatTypeAndCount;
		}
	}
	
	public static void updateSeatOnDate(String date) {
		Connection con = DBConnectionForClient.connect();

		String[] data = new String[2];

		try {
			PreparedStatement pstmt = con.prepareStatement("call getDefaultSeatOnDate(?);",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, date);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				data[0] = rs.getString("train calendar id");
				data[1] = rs.getString("seat No");

				PreparedStatement pstmtu = con.prepareStatement("call createSeatOnDate(?,?);",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmtu.setString(1, data[0]);
				pstmtu.setString(2, data[1]);

				pstmtu.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
