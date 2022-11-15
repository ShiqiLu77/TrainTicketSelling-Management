package com.shiqi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.shiqi.DAOCstm.ClientDAO;
import com.shiqi.guiCstm.FrameClientMain;
import com.shiqi.pojo.Client;
import com.shiqi.guiCstm.FrameLogin;

public class ClientLoginActionListener implements ActionListener {
	private FrameLogin loginFrame;
	private String username;
	private String password;

	public ClientLoginActionListener(FrameLogin loginFrame) {
		super();
		this.loginFrame = loginFrame;
	}
 
	public void actionPerformed(ActionEvent e) {
		username = loginFrame.getTxtUN().getText();
		password = new String(loginFrame.getPwF().getPassword());
		Client c = ClientDAO.Login(username, password);
		if (c!= null) {
			loginFrame.dispose();
			new FrameClientMain(c);
		} else {
			loginFrame.getLblInfo().setText("Invalid username or password");;
		}
	}

}
