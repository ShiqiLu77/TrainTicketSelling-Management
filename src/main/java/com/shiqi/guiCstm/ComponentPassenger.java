package com.shiqi.guiCstm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.shiqi.listener.DeletePassengerFromClientLisener;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Passenger;

public class ComponentPassenger extends JPanel {
	public static int HEIGHT = 60;
	private JButton btnDelete;
	private JLabel lblName;
	private JLabel lblID;
	private String name;
	private String pid;

	public ComponentPassenger(JPanel fpanel, Client c, Passenger p) {
		setLayout(null);
		setSize(new Dimension(570, HEIGHT));
		setBorder(new LineBorder(new Color(230, 230, 230), 1, true));
		setBackground(Color.WHITE);

		name = p.getFname() + " " + p.getLname();
		pid = p.getPid();

		lblName = new JLabel(name);
		lblName.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblName.setBounds(20, HEIGHT / 10, 250, HEIGHT / 2);
		add(lblName);

		lblID = new JLabel(pid.substring(0, 5) + "**********" + pid.substring(pid.length() - 3));
		lblID.setForeground(Color.GRAY);
		lblID.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblID.setBounds(20, HEIGHT / 2-5, 120, HEIGHT / 2);
		add(lblID);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(435, HEIGHT / 4, 110, HEIGHT/2);
		btnDelete.addActionListener(new DeletePassengerFromClientLisener(fpanel, this, c, p));
		add(btnDelete);
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblID() {
		return lblID;
	}

	public void setLblID(JLabel lblID) {
		this.lblID = lblID;
	}
}
