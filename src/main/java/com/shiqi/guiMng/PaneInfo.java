package com.shiqi.guiMng;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.shiqi.DAOMng.SeatDAO;
import com.shiqi.DAOMng.TrainDAO;
import com.shiqi.pojo.Manager;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class PaneInfo extends JPanel {
	private Manager manager;
	private JTabbedPane tabbedPane;
	private JComponent tabTDS;
	private JComponent tabSA;
	private JComponent tabOther;

	private JTable tableTrainSchedule;
	private JTable tableSeatType;

	public PaneInfo(Manager m) {
		manager = m;
		setBounds(0, 0, 800, 520);
		setLayout(null);

		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 780, 470);
		add(tabbedPane);

		/***** Train daily schedule ****/
		tabTDS = new JPanel(null);
		tabbedPane.addTab("Train daily schedule", null, tabTDS, "Some tips");

		/***** seating arrangement ****/
		tabSA = new JPanel(null);
		tabbedPane.addTab("Seating arrangement", null, tabSA, "Some tips");


		String[] columnTrain = { "train id", "from city", "to city", "duration", "leave time", "arrive time",
				"from station", "to station" };
		tableTrainSchedule = new JTable(TrainDAO.getTrainDailySchedule(manager), columnTrain);

		JScrollPane scrollPane1 = new JScrollPane(tableTrainSchedule);
		scrollPane1.setBounds(10, 5, 750, 370);
		tabTDS.add(scrollPane1);


		String[] columnSeat = { "Type id", "Type", "Column", "Location", "Location Description" };
		tableSeatType = new JTable(SeatDAO.getSeatingArrangement(manager), columnSeat);

		JScrollPane scrollPane2 = new JScrollPane(tableSeatType);
		scrollPane2.setBounds(30, 5, 700, 370);
		tabSA.add(scrollPane2);

	}
}
