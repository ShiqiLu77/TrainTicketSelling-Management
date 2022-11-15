package com.shiqi.DAOCstm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shiqi.pojo.Train;

public class TrainDAO {

	public TrainDAO() {

	}
	
	public static ArrayList<Train> getAvaliableTrains(String date, String from, String to) {
		ArrayList<Train> trains = new ArrayList<Train>();
		
		Connection con = DBConnectionForClient.connect();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("call AvailableTrain(?,?,?);",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, date);
			pstmt.setString(2, from);
			pstmt.setString(3, to);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Train t = new Train(rs.getString("tcid"),
						rs.getString("date"), rs.getString("train id"),
						rs.getString("train type"), rs.getString("train type"),
						rs.getString("from city"),rs.getString("to city"),
						rs.getString("from station"),rs.getString("to station"),
						rs.getString("duration"),rs.getString("leave time"),
						rs.getString("arrive time"),rs.getString("from tpsid"),
						rs.getString("to tpsid"),rs.getString("distance"),
						rs.getString("price base"));
				trains.add(t);
			}
			return trains;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Some false in getting avaliable trains");
			return trains;
		}
	}

}
