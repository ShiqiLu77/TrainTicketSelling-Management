package com.shiqi.DAOCstm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shiqi.pojo.Ticket;

public class BookRecordDAO {

	public static void createRecord(String cid, String datetime, ArrayList<Ticket> tickets) {
		Connection con = DBConnectionForClient.connect();
		try {
			for (Ticket t : tickets) {
				PreparedStatement pstmt = con.prepareStatement("Call createBookRecord(?,?,?)",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1, cid);
				pstmt.setString(2, datetime);
				pstmt.setString(3, t.getTicketNumberString());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Some error in creating book record");
			e.printStackTrace();
		}
	}
}
