package com.shiqi.guiCstm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import com.shiqi.DAOCstm.SeatDAO;
import com.shiqi.listener.ConfirmOrderListener;
import com.shiqi.pojo.Train;
import com.shiqi.pojo.Client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class ComponentAvailableTrain extends JPanel {
	private Client client;
//	private AvaliableTrain train;
	private String date;

	public static int HEIGHT = 90;

	private JButton btnBuy;
	private JLabel lblLeaveTime;
	private JLabel lblArriveTime;
	private JLabel lblFromStation;
	private JLabel lblToStation;
	private JLabel lblDuration;
	private JLabel lblSep;
	private JLabel lblTrainID;
	private JLabel lblCrossDays;
	private JLabel lblSeatTypeAndCount;

	private String trainID;
	private String traintype;
	private String fromStation;
	private String toStation;
	private String duration;
	private String leaveTime;
	private String arriveTime;
	private float trainPriceBase;
	private int crossDays = 0; // arrive time cross how many days from leave time

	private ArrayList<String[]> availableSeatTypeCountAndPrice;
	private String[] availableSeatType;

	private HashMap<String, Float> seatTypeAndPrice = new HashMap<String, Float>();
	private HashMap<String, Integer> seatTypeAndCount = new HashMap<String, Integer>();
	private String seatInfo = "SEAT TYPE & PRICE :    ";// seat type and its price

	public ComponentAvailableTrain(TabBook tab, JPanel fPanel, Client c, String d, Train t) {
		this.client = c;
		this.date = d;

		trainID = t.getTrainID();
		traintype = t.getTraintype();
		fromStation = t.getFromStation();
		toStation = t.getToStation();
		duration = t.getDuration();
		leaveTime = t.getLeaveTime();
		arriveTime = t.getArriveTime();
		trainPriceBase = Float.parseFloat(t.getPriceBase());

		setLayout(null);
		setPreferredSize(new Dimension(580, HEIGHT));
		setBackground(Color.WHITE);

		/********************** Train information Panel ******************/
		lblCrossDays = new JLabel();
		lblCrossDays.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		lblCrossDays.setBounds(360, 15, 30, 15);
		lblCrossDays.setVisible(false);
		add(lblCrossDays);
		timeFormatting();

		lblLeaveTime = new JLabel(leaveTime);
		lblLeaveTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveTime.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblLeaveTime.setBounds(45, 20, 100, 25);
		add(lblLeaveTime);

		lblArriveTime = new JLabel(arriveTime);
		lblArriveTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblArriveTime.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblArriveTime.setBounds(280, 20, 100, 25);
		add(lblArriveTime);

		lblFromStation = new JLabel(fromStation);
		lblFromStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblFromStation.setForeground(Color.DARK_GRAY);
		lblFromStation.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblFromStation.setBounds(35, 43, 120, 20);
		add(lblFromStation);

		lblToStation = new JLabel(toStation);
		lblToStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblToStation.setForeground(Color.DARK_GRAY);
		lblToStation.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblToStation.setBounds(270, 43, 120, 20);
		add(lblToStation);

		lblDuration = new JLabel(duration);
		lblDuration.setForeground(Color.GRAY);
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblDuration.setBounds(157, 23, 100, 16);
		add(lblDuration);

		lblSep = new JLabel("_____________");
		lblSep.setForeground(Color.GRAY);
		lblSep.setHorizontalAlignment(SwingConstants.CENTER);
		lblSep.setBounds(157, 25, 100, 16);
		add(lblSep);

		lblTrainID = new JLabel(trainID);
		lblTrainID.setForeground(Color.GRAY);
		lblTrainID.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainID.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblTrainID.setBounds(157, 40, 100, 16);
		add(lblTrainID);

		lblSeatTypeAndCount = new JLabel(seatInfo.stripTrailing());
		lblSeatTypeAndCount.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeatTypeAndCount.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblSeatTypeAndCount.setForeground(new Color(65, 105, 225));
		lblSeatTypeAndCount.setBounds(30, 68, 500, 15);
		add(lblSeatTypeAndCount);

		btnBuy = new JButton("Buy    ");
		btnBuy.addActionListener(new ConfirmOrderListener(tab, c, t));
		btnBuy.setHorizontalAlignment(SwingConstants.RIGHT);
		btnBuy.setForeground(Color.GRAY);
		btnBuy.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		btnBuy.setBounds(-1, -1, 553, HEIGHT + 4);
		add(btnBuy);

	}

	public void timeFormatting() {
		/****** leave/arrive time , cross day ****/
		int aHours = Integer.parseInt(arriveTime.substring(0, 2));
		int lHours = Integer.parseInt(leaveTime.substring(0, 2));
		crossDays = aHours / 24 - lHours / 24;
		if (crossDays != 0) {
			lblCrossDays.setText("+" + crossDays + "d");
			lblCrossDays.setVisible(true);
		}
		arriveTime = aHours % 24 + arriveTime.substring(2, 5);
		leaveTime = lHours % 24 + leaveTime.substring(2, 5);
		duration = duration.substring(0, 2) + "h" + duration.substring(3, 5) + "m";

		/****************** seat ***************/
		availableSeatTypeCountAndPrice = SeatDAO.getAvailableSeatTypeCountAndPrice(date, trainID);
		availableSeatType = new String[availableSeatTypeCountAndPrice.size()];
		
		int i = 0;
		for (String[] s : availableSeatTypeCountAndPrice) {
			availableSeatType[i] = s[0];
			seatTypeAndCount.put(s[0], Integer.parseInt(s[1]));
			float price = new BigDecimal(Float.parseFloat(s[2]) * trainPriceBase).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue(); // 2 decimal
			seatTypeAndPrice.put(s[0], price);
			seatInfo += s[0] + " " + price + "     ";
	//		seatInfo += s[0] + "      ";
			i++;
		}
	}

	public JButton getBtnBuy() {
		return btnBuy;
	}

	public void setBtnBuy(JButton btnBuy) {
		this.btnBuy = btnBuy;
	}

	public ArrayList<String[]> getAvailableSeatTypeCountAndPrice() {
		return availableSeatTypeCountAndPrice;
	}

	public void setAvailableSeatTypeCountAndPrice(ArrayList<String[]> availableSeatTypeCountAndPrice) {
		this.availableSeatTypeCountAndPrice = availableSeatTypeCountAndPrice;
	}

	public JLabel getLblSeatTypeAndCount() {
		return lblSeatTypeAndCount;
	}

	public void setLblSeatTypeAndCount(JLabel lblSeatTypeAndCount) {
		this.lblSeatTypeAndCount = lblSeatTypeAndCount;
	}

	public String[] getAvailableSeatType() {
		return availableSeatType;
	}

	public void setAvailableSeatType(String[] availableSeatType) {
		this.availableSeatType = availableSeatType;
	}

	public HashMap<String, Float> getSeatTypeAndPrice() {
		return seatTypeAndPrice;
	}

	public void setSeatTypeAndPrice(HashMap<String, Float> seatTypeAndPrice) {
		this.seatTypeAndPrice = seatTypeAndPrice;
	}

	public HashMap<String, Integer> getSeatTypeAndCount() {
		return seatTypeAndCount;
	}

	public void setSeatTypeAndCount(HashMap<String, Integer> seatTypeAndCount) {
		this.seatTypeAndCount = seatTypeAndCount;
	}


}
