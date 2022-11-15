package com.shiqi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import com.shiqi.guiCstm.TabBook;
import com.shiqi.guiCstm.DialogTicketDetail;
import com.shiqi.pojo.Train;
import com.shiqi.pojo.Client;

public class ConfirmOrderListener implements ActionListener {
	private JDialog fatherDialog;
	private Client client;
	private Train train;

	public ConfirmOrderListener(TabBook tab, Client client, Train train) {
		super();
		if (tab != null) {
			this.fatherDialog = tab.getFatherFrame();
		} else {
			this.fatherDialog = null;
		}
		this.client = client;
		this.train = train;
	}

	public void actionPerformed(ActionEvent e) {
		new DialogTicketDetail(fatherDialog, client, train);
	}
}
