package com.shiqi.DAOMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import com.mysql.cj.conf.StringProperty;
import com.shiqi.pojo.Manager;

public class TrainDAO {

	public TrainDAO() {
	}

	public static void addTrainCalendar(Manager m, String[] trainCalender) {
		Connection con = new DBConnectionForManager(m).connect();
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT into TicketSellings.`train calendar` (`train ID`, `date`) VALUES (?, ?);",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, trainCalender[0]);
			pstmt.setString(2, trainCalender[1]);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Some false in adding train calendar");
		}

	}

	public static String[] getAllTrain(Manager m) {
		// HashMap<String, String[]> train= new HashMap<String, String[]>();
		Connection con = new DBConnectionForManager(m).connect();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM TicketSellings.`train`;",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = pstmt.executeQuery();

			ArrayList<String> t = new ArrayList<String>();
			while (rs.next()) {
				t.add(rs.getString("tid"));
			}
			String[] train = new String[t.size()];
			int i = 0;
			for (String s : t) {
				train[i] = s;
				i++;
			}
			return train;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Some false in getting all trains");
			return null;
		}
	}

	public static String[][] getTrainDailySchedule(Manager m) {
		ArrayList<String[]> t = new ArrayList<String[]>();
		Connection con = new DBConnectionForManager(m).connect();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM TicketSellings.`train daily schedule`;",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ArrayList<String> train = new ArrayList<String>();
				train.add(rs.getString("train id"));
				train.add(rs.getString("from city"));
				train.add(rs.getString("to city"));
				train.add(rs.getString("duration").substring(0, 5));
				train.add(rs.getString("leave time").substring(0, 5));
				train.add(rs.getString("arrive time").substring(0, 5));
				train.add(rs.getString("from station"));
				train.add(rs.getString("to station"));
				String[] trains = new String[train.size()];
				int i = 0;
				for (String s : train) {
					trains[i] = s;
					i++;
				}
				t.add(trains);
			}
			String[][] trainDailySechdule = new String[t.size()][];
			int i = 0;
			for (String[] s : t) {
				trainDailySechdule[i] = s;
				i++;
			}
			return trainDailySechdule;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Some false in getting avaliable trains");
			return null;
		}
	}
}
