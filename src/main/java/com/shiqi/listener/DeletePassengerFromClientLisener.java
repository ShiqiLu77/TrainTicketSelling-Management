package com.shiqi.listener;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.shiqi.DAOCstm.PassengerDAO;
import com.shiqi.guiCstm.ComponentPassenger;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Passenger;

public class DeletePassengerFromClientLisener implements ActionListener {
	private JPanel fatherPanel;
	private JPanel component;
	private Client client;
	private Passenger passenger;

	public DeletePassengerFromClientLisener(JPanel fatherPanel, JPanel component, Client client, Passenger passenger) {
		super();
		this.fatherPanel = fatherPanel;
		this.component = component;
		this.client = client;
		this.passenger = passenger;
	}

	public void actionPerformed(ActionEvent e) {
		int n = JOptionPane.showConfirmDialog(fatherPanel, "Data cannot be recovered after deleting! ", "Warning",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE); // 0 for OK
		if (n == 0) {
			//System.out.println(client.getCid() + "\t" + passenger.getPid());
			PassengerDAO.deletePassengerFromClient(client, passenger);
			
			fatherPanel.remove(component);
			int height = fatherPanel.getSize().height - (ComponentPassenger.HEIGHT + 2);
			fatherPanel.setPreferredSize(new Dimension(0, height));
		}

	}
}
