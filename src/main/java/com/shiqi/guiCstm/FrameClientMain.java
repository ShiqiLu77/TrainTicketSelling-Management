package com.shiqi.guiCstm;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.shiqi.DAOCstm.TicketDAO;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Ticket;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FrameClientMain extends JDialog {
	private Client client;
	private JTabbedPane tabbedPane;
	private JComponent tabBook;
	private TabMyTicket tabMyTicket;
	private JComponent tabSettings;

	/**
	 * Create the frame.
	 */
	public FrameClientMain(Client c) {
		client = c;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(450, 200, 600, 450);

		tabbedPane = new JTabbedPane();

		tabBook = new TabBook(this, c);
		tabbedPane.addTab("Book Ticket", null, tabBook, "Some tips");

		tabMyTicket = new TabMyTicket(null, c, tabbedPane);
		tabbedPane.addTab("My ticket", null, tabMyTicket, "Some tips");

		tabSettings = new TabSettings(null, c);
		tabbedPane.addTab("Settings", null, tabSettings, "Some tips");

		getContentPane().add(tabbedPane);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 1) {
					JPanel pnl = tabMyTicket.getPnlDeafult().getPnlInScroll();
					pnl.removeAll();
					pnl.repaint();
					 ArrayList<Ticket> tickets = TicketDAO.myUnusedTickets(client.getCid());
					int n = 0;// count component numbers
					for (Ticket t : tickets) {
						n = n + 1;
						ComponentTicket ticket = new ComponentTicket(t);
						pnl.add(ticket);
					}
					int height = (ComponentTicket.HEIGHT + 2) * n;
					pnl.setPreferredSize(new Dimension(0, height));
					pnl.revalidate();
				}
			}
		});
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public JComponent getTabBook() {
		return tabBook;
	}

	public void setTabBook(JComponent tabBook) {
		this.tabBook = tabBook;
	}

	public JComponent getTabMyTicket() {
		return tabMyTicket;
	}

	public void setTabMyTicket(TabMyTicket tabMyTicket) {
		this.tabMyTicket = tabMyTicket;
	}

	public JComponent getTabSettings() {
		return tabSettings;
	}

	public void setTabSettings(JComponent tabSettings) {
		this.tabSettings = tabSettings;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
