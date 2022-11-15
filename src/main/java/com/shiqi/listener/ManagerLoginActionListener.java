package com.shiqi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.shiqi.guiCstm.FrameLogin;
import com.shiqi.guiMng.FrameManagerMain;
import com.shiqi.pojo.Manager;


public class ManagerLoginActionListener implements ActionListener {
	private FrameLogin loginFrame;
	private String username;
	private String password;

	public ManagerLoginActionListener(FrameLogin loginFrame) {
		super();
		this.loginFrame = loginFrame;
	}

	public void actionPerformed(ActionEvent e) {
		username = loginFrame.getTxtMN().getText();
		password = new String(loginFrame.getPwFM().getPassword());

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicketSellings", username,
					password);
			loginFrame.dispose();
			new FrameManagerMain(new Manager(username, password));
		} catch (SQLException e1) {
			loginFrame.getLblInfoM().setText("Invalid username or password");
			e1.printStackTrace();
		}
	}
}
