package com.shiqi.guiMng;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.shiqi.DAOMng.DateDAO;
import com.shiqi.DAOMng.SeatDAO;
import com.shiqi.DAOMng.TrainDAO;
import com.shiqi.pojo.Manager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaneHome extends JPanel {
	private Manager manager;
	private JTable table;
	private JTable tbSchedule;
	private JLabel lblInfo;
	
	private String selectedDate;
	private String[] train;
	private	String[] column = {"date","train ID","Y/N"};;
	private String[][] row;
	
	
	public PaneHome(Manager m) {
		manager = m;
		setBounds(0, 0, 800, 520);
		setLayout(null);
	
		String[] dateNotArranged = DateDAO.getDateNotArranged(m);
		selectedDate = dateNotArranged[0];		
		train = TrainDAO.getAllTrain(m);
		System.out.println(train.length);
		row = new String[train.length][3];
		for (int i = 0; i< train.length;i++) {
			row[i][0] = train[i];
			row[i][1] = selectedDate;
			row[i][2] = "Y";
		}
		
		JComboBox cbxDate = new JComboBox(dateNotArranged);
		cbxDate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				selectedDate= (String) e.getItem();
				for (int i = 0; i< train.length;i++) {
					tbSchedule.setValueAt(selectedDate,i, 1);
					row[i][1] = selectedDate;
				}
				tbSchedule.repaint();
			}
		});
		cbxDate.setBounds(340, 55, 130, 30);
		add(cbxDate);
		
		/****** train schedule *****/

		tbSchedule = new JTable(row,column);
		add(tbSchedule);
		
		JScrollPane scrollPane = new JScrollPane(tbSchedule);
		scrollPane.setBounds(70, 100, 400, 230);
		add(scrollPane);
		
		JLabel lblSchedule = new JLabel("Generate train schedule data");
		lblSchedule.setBounds(510, 140, 200, 30);
		add(lblSchedule);
		
		JButton btnSchedule = new JButton("Create");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String[] t:row) {
					TrainDAO.addTrainCalendar(manager, t);
					SeatDAO.updateSeatOnDate(manager,selectedDate);
					lblInfo.setText("Update successfully");
				}
			}
		});
		btnSchedule.setBounds(525, 240, 160, 40);
		add(btnSchedule);

		
		/****** seat *****/
		JLabel lblSeat = new JLabel("and seats on these train data");
		lblSeat.setBounds(510, 165, 200, 30);
		add(lblSeat);
		
		JLabel lblCreateDefaultTrain = new JLabel("Create default train schedule on date");
		lblCreateDefaultTrain.setBounds(70, 55, 250, 30);
		add(lblCreateDefaultTrain);
		
		JLabel lblInDatabase = new JLabel("in Database");
		lblInDatabase.setBounds(510, 190, 200, 30);
		add(lblInDatabase);
		
		lblInfo = new JLabel("");
		lblInfo.setBounds(70, 350, 400, 20);
		add(lblInfo);
	}
}
