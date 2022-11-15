package com.shiqi.listener;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.shiqi.DAOCstm.PassengerDAO;
import com.shiqi.guiCstm.ComponentCreateNewPassenger;
import com.shiqi.guiCstm.ComponentPassenger;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Passenger;
import com.shiqi.utility.SearchAvaliableTrain;
import com.shiqi.utility.SetDeaultText;
import com.shiqi.utility.ShowPassenger;

public class CreatePassengerUnderClientListener implements ActionListener {
	private JPanel fatherPanel;
	private ComponentCreateNewPassenger component;
	private Client client;
	private Passenger passenger;

	public CreatePassengerUnderClientListener(JPanel fatherPanel, ComponentCreateNewPassenger component, Client client) {
		super();
		this.fatherPanel = fatherPanel;
		this.component = component;
		this.client = client;
	}

	public void actionPerformed(ActionEvent e) {
		passenger = new Passenger(component.getTxtID().getText(), component.getTxtFName().getText(), component.getTxtLName().getText());
		PassengerDAO.createNewPassenger(passenger);
		PassengerDAO.savePassengerUnderClient(client, passenger);
		
		fatherPanel.removeAll();
		fatherPanel.repaint();
		fatherPanel.add(new ComponentCreateNewPassenger(fatherPanel,client));
		new ShowPassenger(fatherPanel, client);
		fatherPanel.revalidate();

		component.getBtnAdd().setVisible(true);
		
		component.getTxtFName().setVisible(false);
		new SetDeaultText(component.getTxtFName(), "First name");
		component.getTxtLName().setVisible(false);
		new SetDeaultText(component.getTxtLName(), "Last name");
		component.getTxtID().setVisible(false);
		new SetDeaultText(component.getTxtID(), "ID number");
		component.getBtnSave().setVisible(false);
		component.getBtnCancel().setVisible(false);
	}

}
