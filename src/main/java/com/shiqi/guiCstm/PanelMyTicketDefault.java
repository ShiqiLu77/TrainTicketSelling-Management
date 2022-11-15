package com.shiqi.guiCstm;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import com.shiqi.DAOCstm.TicketDAO;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Ticket;

import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.SystemColor;

import java.awt.Font;

public class PanelMyTicketDefault extends JPanel {
	private TabMyTicket fatherTab;
	private JLabel lblUT;
	private JLabel lblUUT;
	private JScrollPane pnlUUT;
	private JPanel pnlInScroll;
	private JButton btnUT;
	private ArrayList<Ticket> tickets;

	/**
	 * Create the panel.
	 */
	public PanelMyTicketDefault(TabMyTicket tab, Client c) {
		fatherTab = tab;
		setLayout(null);
		setBounds(0, 0, 580, 380);
		
		/* Unused Tickets */
		lblUUT = new JLabel("Unused Tickets");
		lblUUT.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUUT.setBounds(10, 5, 150, 30);
		add(lblUUT);

		pnlInScroll = new JPanel();
		pnlInScroll.setLayout(new GridLayout(0, 1, 0, 0));
		pnlInScroll.setBackground(SystemColor.window);

		pnlUUT = new JScrollPane(pnlInScroll);
		pnlUUT.setBounds(5, 40, 570, 300);
		add(pnlUUT);
		
		tickets = TicketDAO.myUnusedTickets(c.getCid());
		int n = 0;// count component numbers
		for (Ticket t : tickets) {
			n = n + 1;
			ComponentTicket ticket = new ComponentTicket(t);
			pnlInScroll.add(ticket);
		}
		int height = (ComponentTicket.HEIGHT + 2) * n;
		pnlInScroll.setPreferredSize(new Dimension(0, height));
		

		/*------------------------------------------------------*/
		
		/* Unpaid Tickets */
//		lblUPT = new JLabel("Unpaid Tickets");
//		lblUPT.setBounds(5, 211, 100, 16);
//		add(lblUPT);
//
//		pnlUPT = new JPanel(new GridLayout());
//		pnlUPT.setBorder(new LineBorder(Color.LIGHT_GRAY));
//		pnlUPT.setBounds(5, 239, 565, 95);
//		pnlUPT.setBackground(Color.WHITE);
//		add(pnlUPT);
//
//		showTicket(pnlUPT, 1);
		
		/** Used Tickets
		 * 
		 */
		lblUT = new JLabel("Used Tickets");
		lblUT.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUT.setBounds(10, 345, 100, 30);
		add(lblUT);

		btnUT = new JButton("Show");
		btnUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				fatherTab.getPnlUsedTikets().setVisible(true);
			}
		});
		btnUT.setBounds(445, 345, 120, 30);
		add(btnUT);
		/*------------------------------------------------------*/

	}

	private void showTicket(JPanel pnl, int piao) {
		if (piao >= 1) {
			for (int i = 1; i <= piao; i++) {
				//JPanel component = new ComponentAvailableTrain();
				//pnl.add(component);
			}
		} else {
			JLabel lblNewLabel = new JLabel("There are no history tickets");
			lblNewLabel.setForeground(Color.GRAY);
			lblNewLabel.setBounds(17, 6, 200, 16);
			pnl.add(lblNewLabel);
		}
	}

	public JPanel getPnlInScroll() {
		return pnlInScroll;
	}

	public void setPnlInScroll(JPanel pnlInScroll) {
		this.pnlInScroll = pnlInScroll;
	}
	
}
