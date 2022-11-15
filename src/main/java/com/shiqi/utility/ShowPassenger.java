package com.shiqi.utility;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.shiqi.DAOCstm.PassengerDAO;
import com.shiqi.guiCstm.ComponentPassenger;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Passenger;

public class ShowPassenger {
	private ArrayList<Passenger> psgs;

	public ShowPassenger(JPanel panel, Client client) {
		psgs = PassengerDAO.getPassengers(client);
		int n = 0;// count component numbers
		for (Passenger p : psgs) {
			n = n + 1;
			ComponentPassenger psg = new ComponentPassenger(panel, client, p);
			panel.add(psg);
		}
		int height = (ComponentPassenger.HEIGHT + 2) * (n + 1);
		panel.setPreferredSize(new Dimension(0, height));
//		panel.setMaximumSize(new Dimension(0, height));
		panel.revalidate();

	}
}