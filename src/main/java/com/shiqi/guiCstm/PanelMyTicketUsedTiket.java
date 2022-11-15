package com.shiqi.guiCstm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.shiqi.DAOCstm.TicketDAO;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Ticket;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PanelMyTicketUsedTiket extends JPanel {
	private TabMyTicket fatherTab;
	private JPanel pnlInScroll;
	private ArrayList<Ticket> tickets;


	/**
	 * Create the panel.
	 */
	public PanelMyTicketUsedTiket(TabMyTicket tab, Client c) {
		fatherTab = tab;
		setLayout(null);
		setBounds(0, 0, 580, 380);

		pnlInScroll = new JPanel();
		pnlInScroll.setLayout(new GridLayout(0, 1, 0, 0));
		pnlInScroll.setBackground(SystemColor.window);
		
		tickets = TicketDAO.myUsedTickets(c.getCid());
		int n = 0;// count component numbers
		for (Ticket t : tickets) {
			n = n + 1;
			ComponentTicket ticket = new ComponentTicket(t);
			pnlInScroll.add(ticket);
		}
		int height = (ComponentTicket.HEIGHT + 2) * n;
		pnlInScroll.setPreferredSize(new Dimension(0, height));

		JScrollPane scrollPane = new JScrollPane(pnlInScroll);
		scrollPane.setBounds(5, 40, 570, 335);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("My History Orders");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 5, 150, 30);
		add(lblNewLabel);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				fatherTab.getPnlDeafult().setVisible(true);
			}
		});
		btnBack.setBounds(445, 5, 120, 29);
		add(btnBack);
	}

//	public void add_availableTrain() {
//		ComponentAvailableTrain cpnt = new ComponentAvailableTrain(null,null);
//		cpnt.setBorder(new LineBorder(Color.LIGHT_GRAY));
//		cpnt.getBtnBuy().setText("  ");;
//
//		pnlInScroll.add(cpnt);
//	}
}
