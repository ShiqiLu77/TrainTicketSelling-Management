package com.shiqi.guiCstm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.shiqi.pojo.Ticket;

public class ComponentTicket extends JPanel {
//	private Client client;
//	private AvaliableTrain train;

	public static int HEIGHT = 120;
	
	private JLabel lblLeaveTime;
	private JLabel lblArriveTime;
	private JLabel lblFromStation;
	private JLabel lblToStation;
	private JLabel lblDuration;
	private JLabel lblSep;
	private JLabel lblTrainIDValue;
	private JLabel lblCrossDays;
	private JLabel lblDateValue;
	private JLabel lblPassenger;
	private JLabel lblPsgName;
	private JLabel lblPsgID;
	private JLabel lblDate;
	private JLabel lblPSeat;
	private JLabel lblCarriage;
	private JLabel lblRow;
	private JLabel lblColumn;
	private JLabel lblTrainID;
	private JLabel lblPrice;
	private JLabel lblRmb;

	private String duration;
	private String leaveTime;
	private String arriveTime;
	private int crossDays = 0; // arrive time cross how many days from leave time

	public ComponentTicket(Ticket t) {

		duration = t.getDuration();
		leaveTime = t.getLeaveTime();
		arriveTime = t.getArriveTime();
		
		setLayout(null);
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setSize(new Dimension(570, 120));
		setBackground(Color.WHITE);
		
		lblCrossDays = new JLabel();
		lblCrossDays.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		lblCrossDays.setBounds(320, 37, 30, 15);
		lblCrossDays.setVisible(false);
		add(lblCrossDays);
		timeFormatting();

		lblLeaveTime = new JLabel(leaveTime);
		lblLeaveTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveTime.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblLeaveTime.setBounds(40, 40, 100, 25);
		add(lblLeaveTime);

		lblArriveTime = new JLabel(arriveTime);
		lblArriveTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblArriveTime.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblArriveTime.setBounds(230, 40, 100, 25);
		add(lblArriveTime);

		lblFromStation = new JLabel(t.getFromStation());
		lblFromStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblFromStation.setForeground(Color.GRAY);
		lblFromStation.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblFromStation.setBounds(30, 60, 120, 15);
		add(lblFromStation);

		lblToStation = new JLabel(t.getToStation());
		lblToStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblToStation.setForeground(Color.GRAY);
		lblToStation.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblToStation.setBounds(220, 60, 120, 15);
		add(lblToStation);

		lblDuration = new JLabel(duration);
		lblDuration.setForeground(Color.GRAY);
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblDuration.setBounds(135, 48, 100, 16);
		add(lblDuration);

		lblSep = new JLabel("___________");
		lblSep.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblSep.setForeground(Color.GRAY);
		lblSep.setHorizontalAlignment(SwingConstants.CENTER);
		lblSep.setBounds(135, 50, 100, 16);
		add(lblSep);
		
		lblTrainID = new JLabel("Train");
		lblTrainID.setForeground(Color.GRAY);
		lblTrainID.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTrainID.setBounds(200, 15, 40, 15);
		add(lblTrainID);

		lblTrainIDValue = new JLabel(t.getTrainID());
		lblTrainIDValue.setForeground(Color.BLACK);
		lblTrainIDValue.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblTrainIDValue.setBounds(250, 15, 100, 15);
		add(lblTrainIDValue);
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(Color.GRAY);
		lblDate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDate.setBounds(20, 15, 40, 15);
		add(lblDate);
		
		lblDateValue = new JLabel(t.getDate());
		lblDateValue.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblDateValue.setBounds(65, 15, 100, 15);
		add(lblDateValue);
		
		lblPassenger = new JLabel("Passenger");
		lblPassenger.setForeground(Color.GRAY);
		lblPassenger.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPassenger.setBounds(390, 15, 100, 15);
		add(lblPassenger);
		
		lblPsgName = new JLabel(t.getPassengerName());
		lblPsgName.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPsgName.setBounds(390, 40, 150, 20);
		add(lblPsgName);
		
		lblPsgID = new JLabel(t.getPassengerID());
		lblPsgID.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPsgID.setBounds(390, 55, 150, 20);
		add(lblPsgID);
		
		lblPSeat = new JLabel("Seat");
		lblPSeat.setForeground(Color.GRAY);
		lblPSeat.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPSeat.setBounds(20, 90, 40, 15);
		add(lblPSeat);
		
		lblCarriage = new JLabel("carriage: " + t.getCarriage());
		lblCarriage.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblCarriage.setBounds(65, 90, 85, 15);
		add(lblCarriage);
		
		lblRow = new JLabel("row: " + t.getRow());
		lblRow.setHorizontalAlignment(SwingConstants.CENTER);
		lblRow.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblRow.setBounds(150, 90, 50, 15);
		add(lblRow);
		
		lblColumn = new JLabel("column: " + t.getColumn());
		lblColumn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblColumn.setBounds(210, 90, 80, 15);
		add(lblColumn);
		
		lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.GRAY);
		lblPrice.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPrice.setBounds(390, 90, 50, 15);
		add(lblPrice);
		
		lblRmb = new JLabel("RMB " + t.getPrice());
		lblRmb.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblRmb.setBounds(435, 90, 100, 15);
		add(lblRmb);
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
	}
}
