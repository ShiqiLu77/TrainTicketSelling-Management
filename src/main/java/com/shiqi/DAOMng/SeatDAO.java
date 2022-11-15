package com.shiqi.DAOMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shiqi.DAOCstm.DBConnectionForClient;
import com.shiqi.pojo.Manager;

public class SeatDAO {
	
	public static String[][] getSeatingArrangement(Manager m) {
		ArrayList<String[]> s = new ArrayList<String[]>();
		Connection con = new DBConnectionForManager(m).connect();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM TicketSellings.`seatting arrangement type`;",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ArrayList<String> seat = new ArrayList<String>();
				seat.add(rs.getString("arrangement id"));
				seat.add(rs.getString("arrangement type"));
				seat.add(rs.getString("column SN"));
				seat.add(rs.getString("Location"));
				seat.add(rs.getString("description"));
				String[] seats = new String[seat.size()];
				int i = 0;
				for (String str: seat) {
					seats[i] = str;
					i++;
				}
				s.add(seats);
			}
				String[][] seattingArrangementType = new String[s.size()][];
				int i = 0;
			for (String[] str: s) {
				seattingArrangementType[i] = str;
				i++;
			}
			return seattingArrangementType;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Some false in getting avaliable trains");
			return null;
		}
	}
	
	public static void updateSeatOnDate(Manager m,String date) {
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
