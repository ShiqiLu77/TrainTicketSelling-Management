package com.shiqi.DAOMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shiqi.pojo.Manager;

public class DateDAO {
	public DateDAO() {
	}

	public static String[] getDateNotArranged(Manager m) {
		ArrayList<String> d = new ArrayList<String>();
		
		Connection con = new DBConnectionForManager(m).connect();
		try {
			PreparedStatement pstmt = con.prepareStatement("call `dateNotArranged`;",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				d.add(rs.getString("date"));
				}
			
			String[] dates = new String[d.size()];
			int i = 0;
			for (String date: d) {
				dates[i] = date;
				i++;}
			return dates;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Some false in getting dates");
			return null;
		}
	}

}
