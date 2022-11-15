package com.shiqi.guiCstm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import com.shiqi.DAOCstm.TicketDAO;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Ticket;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DialogTicketPay extends JDialog {
	private Client client;
	private ArrayList<Ticket> tickets;

	private JPanel pnlInScroll;
	private JScrollPane scrollPane;

	public DialogTicketPay(Client c, ArrayList<Ticket> tickets) {
		this.tickets = tickets;
		this.client = c;
		this.addWindowListener(new CancelPayActionListener(this));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(520, 170, 580, 215);
		getContentPane().setLayout(null);
		
		float total = 0;
		for (Ticket t: tickets) {
			total += Float.parseFloat(t.getPrice());
		}

		pnlInScroll = new JPanel();
		pnlInScroll.setLayout(new GridLayout(0, 1, 0, 0));
		pnlInScroll.setBackground(Color.WHITE);
		addComponentTicket(pnlInScroll);

		scrollPane = new JScrollPane(pnlInScroll);
		scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		scrollPane.setBounds(0, 0, 580, 150);
		getContentPane().add(scrollPane);

		JLabel lblPrice = new JLabel("Total cost: RMB " + total);
		lblPrice.setForeground(new Color(65, 105, 225));
		lblPrice.setBounds(20, 150, 200, 40);
		getContentPane().add(lblPrice);

		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new PayActionListener(this));
		btnPay.setBounds(450, 155, 120, 30);
		getContentPane().add(btnPay);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new CancelPayActionListener(this));
		btnCancel.setBounds(320, 155, 120, 30);
		getContentPane().add(btnCancel);

	}

	private class PayActionListener implements ActionListener {
		private DialogTicketPay dialog;

		public PayActionListener(DialogTicketPay dialog) {
			super();
			this.dialog = dialog;
		}

		public void actionPerformed(ActionEvent e) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			TicketDAO.payTicket(client.getCid(), dateFormat.format(new Date()), tickets);
			JOptionPane.showMessageDialog(dialog, "Pay successfully!");
			dialog.dispose();
		}
	}

	private class CancelPayActionListener implements ActionListener, WindowListener {
		private DialogTicketPay dialog;

		public CancelPayActionListener(DialogTicketPay dialog) {
			super();
			this.dialog = dialog;
		}

		public void actionPerformed(ActionEvent e) {
			int n = JOptionPane.showConfirmDialog(dialog,
					"If cancelling the payment, the currently seat will be released\t Are you sure to cancel?", null,
					JOptionPane.YES_NO_OPTION);
			// n = 0 -> yes ; n=1 -> no
			if (n == 0) {
				TicketDAO.unpayTicket(tickets);
				dialog.dispose();
			}

		}

		public void windowClosing(WindowEvent e) {
			int n = JOptionPane.showConfirmDialog(dialog,
					"If cancelling the payment, the currently seat will be released\t Are you sure to cancel?", null,
					JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				TicketDAO.unpayTicket(tickets);
				dialog.dispose();
			}
		}

		public void windowClosed(WindowEvent e) {

		}

		public void windowIconified(WindowEvent e) {

		}

		public void windowDeiconified(WindowEvent e) {

		}

		public void windowActivated(WindowEvent e) {

		}

		public void windowDeactivated(WindowEvent e) {

		}
		
		public void windowOpened(WindowEvent e) {

		}
	}

	private void addComponentTicket(JPanel panel) {
		int n = 0;// count component numbers
		for (Ticket t : tickets) {
			n = n + 1;
			ComponentTicket ticket = new ComponentTicket(t);
			panel.add(ticket);
		}
		int height = (ComponentTicket.HEIGHT + 2) * n;
		panel.setPreferredSize(new Dimension(0, height));
	}
}
