package com.shiqi.guiCstm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

import com.shiqi.utility.SetDeaultText;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelBookDefault extends JPanel {
	private TabBook fatherTab;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtDate;
	private JLabel lblInfo;

	/**
	 * Create the panel.
	 */
	public PanelBookDefault(TabBook tab) {
		fatherTab = tab;
		setBounds(0, 0, 580, 380);
		setLayout(null);

		txtFrom = new JTextField();
		txtFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		txtFrom.setBounds(135, 90, 160, 50);
		add(txtFrom);
		new SetDeaultText(txtFrom, "beijing");

		txtTo = new JTextField();
		txtTo.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		txtTo.setBounds(340, 90, 160, 50);
		add(txtTo);
		new SetDeaultText(txtTo, "toronto");

		txtDate = new JTextField();
		txtDate.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtDate.setBounds(135, 160, 160, 35);
		add(txtDate);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		new SetDeaultText(txtDate, dateFormat.format(new Date()));

		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblTo.setBounds(310, 90, 40, 50);
		add(lblTo);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblFrom.setBounds(85, 90, 50, 50);
		add(lblFrom);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblDate.setBounds(85, 160, 40, 35);
		add(lblDate);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(210, 225, 160, 40);
		add(btnSearch);

		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblInfo.setForeground(Color.RED);
		lblInfo.setBounds(170, 210, 240, 15);
		add(lblInfo);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = null;
				String from = null;
				String to = null;
				if (txtDate.getForeground() == (Color.black)) {
					date = txtDate.getText();
				}
				if (txtFrom.getForeground() == (Color.black)) {
					from = txtFrom.getText();
				}
				if (txtTo.getForeground() == (Color.black)) {
					to = txtTo.getText();
				}
				if (date == null || from == null || to == null) {
					lblInfo.setText("Please enter needed information");
				} else {
					setVisible(false);
					fatherTab.setPnlSearch(new PanelBookSearch(fatherTab, fatherTab.getClient(), date, from, to));
					fatherTab.add(fatherTab.getPnlSearch());
					fatherTab.getPnlSearch().setVisible(true);
				}
			}
		});
	}
}
