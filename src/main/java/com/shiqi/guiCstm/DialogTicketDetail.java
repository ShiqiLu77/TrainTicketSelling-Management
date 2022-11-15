package com.shiqi.guiCstm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.shiqi.DAOCstm.PassengerDAO;
import com.shiqi.DAOCstm.SeatDAO;
import com.shiqi.listener.PassengerSelectedListener;
import com.shiqi.pojo.Train;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Passenger;
import com.shiqi.utility.GetTicket;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DialogTicketDetail extends JDialog {
	private final JPanel contentPane = new JPanel();
	private ComponentPreferedSeatLocation compPreferredLocation;
	private JLabel lblPrice;
	private Train train;

	private String[] availableSeatType;
	private HashMap<String, Float> seatTypeAndPrice;
	private ArrayList<Passenger> psgs;

	private String selectedSeatType;
	private ArrayList<String> selectedPID = new ArrayList<String>();
	private ArrayList<String> preferredLocation = new ArrayList<String>();

	public DialogTicketDetail(JDialog fDialog, Client c, Train t) {
		//super(fDialog, "Ticket Details", true);
		this.train = t;
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setVisible(true);
		setBounds(520, 120, 450, 575);
		getContentPane().setLayout(null);

		contentPane.setBounds(0, 0, 450, 510);
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

		JLabel lblTitle = new JLabel("Confirming order");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTitle.setBounds(10, 10, 430, 20);
		contentPane.add(lblTitle);

		/********** train info ********/

		ComponentAvailableTrain train = new ComponentAvailableTrain(null, contentPane, c, t.getDate(), t);
		train.setBounds(0, 64, 450, 81);
		train.setBorder(new LineBorder(new Color(192, 192, 192)));
		train.getBtnBuy().setVisible(false);
		train.getLblSeatTypeAndCount().setVisible(false);
		contentPane.add(train);

		/************** seat type ************/
		availableSeatType = train.getAvailableSeatType();
		seatTypeAndPrice = train.getSeatTypeAndPrice();
		selectedSeatType = availableSeatType[0];

		JLabel lblInfo1 = new JLabel("Please choose seat type");
		lblInfo1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblInfo1.setBounds(10, 160, 430, 20);
		contentPane.add(lblInfo1);
		/*************************************/

		/************** passenger ************/
		psgs = PassengerDAO.getPassengers(c);

		JLabel lblInfo2 = new JLabel("Please choose passengers");
		lblInfo2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblInfo2.setBounds(10, 240, 430, 20);
		contentPane.add(lblInfo2);

		JPanel pnlPassenger = new JPanel();
		pnlPassenger.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		pnlPassenger.setBackground(Color.WHITE);
		pnlPassenger.setLayout(null);
		pnlPassenger.setBounds(0, 265, 450, 120);
		contentPane.add(pnlPassenger);

		int n = 0;// count number of passengers;
		for (Passenger p : psgs) {
			n = n + 1;
			String pName = p.getFname() + " " + p.getLname();
			String pID = p.getPid();

			JCheckBox cbxPname = new JCheckBox(pName);
			cbxPname.setName(pID);
			cbxPname.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			cbxPname.addItemListener(new PassengerSelectedListener(selectedPID,cbxPname));

			JLabel lblPid = new JLabel(pID.substring(0, 5) + "*****" + pID.substring(p.getPid().length() - 3));
			lblPid.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
			lblPid.setForeground(Color.GRAY);

			if (n % 2 == 1) {
				cbxPname.setBounds(10, 8 + 20 * (n / 2), 140, 20);
				lblPid.setBounds(155, 8 + 20 * (n / 2), 75, 20);
			} else {
				cbxPname.setBounds(230, 8 + 20 * (n / 2 - 1), 140, 20);
				lblPid.setBounds(360, 8 + 20 * (n / 2 - 1), 75, 20);
			}
			pnlPassenger.add(cbxPname);
			pnlPassenger.add(lblPid);
		}
		/******************************************/

		/*************** seat location **************/
		JLabel lblInfo3 = new JLabel("Please choose your prefered location");
		lblInfo3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblInfo3.setBounds(10, 400, 430, 20);
		contentPane.add(lblInfo3);

		compPreferredLocation = new ComponentPreferedSeatLocation(selectedSeatType, preferredLocation);
		compPreferredLocation.setBounds(0, 425, 450, 85);
		contentPane.add(compPreferredLocation);
		
		JPanel pnlSeatType = new JPanel();
		pnlSeatType.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		pnlSeatType.setBackground(Color.WHITE);
		pnlSeatType.setBounds(0, 185, 450, 40);
		contentPane.add(pnlSeatType);
				pnlSeatType.setLayout(null);
		
				lblPrice = new JLabel("RMB   " + seatTypeAndPrice.get(selectedSeatType));
				lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
				lblPrice.setBounds(330, 5, 100, 30);
				pnlSeatType.add(lblPrice);
				lblPrice.setForeground(Color.DARK_GRAY);
				
						JComboBox cbxSeatType = new JComboBox(availableSeatType);
						cbxSeatType.setBounds(10, 5, 200, 30);
						pnlSeatType.add(cbxSeatType);
						
						JPanel pnlDate = new JPanel();
						pnlDate.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
						pnlDate.setBackground(Color.WHITE);
						pnlDate.setBounds(0, 35, 450, 30);
						contentPane.add(pnlDate);
						pnlDate.setLayout(null);
						JLabel lblDate = new JLabel(t.getDate());
						lblDate.setBounds(10, 7, 160, 20);
						pnlDate.add(lblDate);
						lblDate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
						cbxSeatType.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent e) {
								selectedSeatType = (String) e.getItem();
								lblPrice.setText("RMB   " + seatTypeAndPrice.get(selectedSeatType));
								compPreferredLocation.choosePnlToShow(selectedSeatType);
							}
						});
		/*****************************************/

		/************** button Pane **************/
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 515, 450, 40);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ConfirmTicketDetailListener(this,c));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new CancelTicketDetailListener(this));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}
	
	public class ConfirmTicketDetailListener implements ActionListener{
		private DialogTicketDetail ticketDetailDialog;
		private Client client;
		
		public ConfirmTicketDetailListener(DialogTicketDetail ticketDetailDialog, Client client) {
			super();
			this.client = client;
			this.ticketDetailDialog = ticketDetailDialog;
		}

		public void actionPerformed(ActionEvent e) {
			new GetTicket(ticketDetailDialog,client,train,selectedSeatType,selectedPID,preferredLocation);
		}
	}
	
	
	public class CancelTicketDetailListener implements ActionListener{
		private DialogTicketDetail ticketDetailDialog;
		
		public CancelTicketDetailListener(DialogTicketDetail ticketDetailDialog) {
			super();
			this.ticketDetailDialog = ticketDetailDialog;
		}

		public void actionPerformed(ActionEvent e) {
			ticketDetailDialog.dispose();
		}
	}
}


