package com.shiqi.guiCstm;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.mysql.cj.x.protobuf.MysqlxExpr.ColumnIdentifier;
import com.shiqi.DAOCstm.ClientDAO;
import com.shiqi.pojo.Client;
import com.shiqi.utility.ShowPassenger;
import java.awt.Font;

public class PanelSettingsDefault extends JPanel {
	private TabSettings fatherTab;
	private Client client;
	private String cid;
	private String phone;
	private String email;

	private JLabel lblMyInfo;
	private JPanel pnlMyInfo;
	private JButton btnMIEdit;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblPhoneValue;
	private JLabel lblEmailValue;

	private JButton btnMISave;
	private JTextField txtPhoneValue;
	private JTextField txtEmailValue;

	private JLabel lblMyPsg;
	private JScrollPane scPMyPsg;
	private JPanel pnlInScroll;

	public PanelSettingsDefault(TabSettings tab, Client c) {
		fatherTab = tab;
		client = c;
		cid = c.getCid();
		phone = c.getPhone();
		email = c.getEmail();
		setLayout(null);
		setBounds(0, 0, 580, 380);

		/***************** My Information *****************/
		lblMyInfo = new JLabel("My Infomation");
		lblMyInfo.setBounds(10, 5, 150, 20);
		add(lblMyInfo);

		pnlMyInfo = new JPanel();
		pnlMyInfo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlMyInfo.setBounds(5, 30, 570, 60);
		pnlMyInfo.setBackground(Color.WHITE);
		add(pnlMyInfo);
		pnlMyInfo.setLayout(null);

		lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(20, 10, 100, 20);
		pnlMyInfo.add(lblPhone);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 30, 100, 20);
		pnlMyInfo.add(lblEmail);

		if (phone == null) {
			lblPhoneValue = new JLabel("No phone number yet");
		} else {
			lblPhoneValue = new JLabel(phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4));
		}
		lblPhoneValue.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblPhoneValue.setForeground(Color.DARK_GRAY);
		lblPhoneValue.setBounds(150, 10, 150, 20);
		pnlMyInfo.add(lblPhoneValue);
		
		if (email == null) {
			lblEmailValue = new JLabel("No Email address yet");
		} else {
			lblEmailValue = new JLabel(email.substring(0, 1) + "****" + email.substring(email.length() - 5));
		}
		lblEmailValue.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblEmailValue.setForeground(Color.DARK_GRAY);
		lblEmailValue.setBounds(150, 30, 150, 20);
		pnlMyInfo.add(lblEmailValue);

		btnMIEdit = new JButton("Edit");
		btnMIEdit.setBounds(435, 15, 110, 30);
		btnMIEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMIEdit.setVisible(false);
				lblPhoneValue.setVisible(false);
				lblEmailValue.setVisible(false);

				btnMISave.setVisible(true);
				txtPhoneValue.setVisible(true);
				txtEmailValue.setVisible(true);
			}
		});
		pnlMyInfo.add(btnMIEdit);
		
		btnMISave = new JButton("Save");
		btnMISave.setBounds(435, 15, 110, 30);
		btnMISave.setVisible(false);
		btnMISave.addActionListener(new saveInfoLisetener());
		pnlMyInfo.add(btnMISave);


		txtPhoneValue = new JTextField(lblPhoneValue.getText());
		txtPhoneValue.setForeground(Color.DARK_GRAY);
		txtPhoneValue.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtPhoneValue.setBounds(145, 11, 150, 20);
		txtPhoneValue.setVisible(false);
		pnlMyInfo.add(txtPhoneValue);

		txtEmailValue = new JTextField(lblEmailValue.getText());
		txtEmailValue.setForeground(Color.DARK_GRAY);
		txtEmailValue.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtEmailValue.setBounds(145, 31, 150, 20);
		txtEmailValue.setVisible(false);
		pnlMyInfo.add(txtEmailValue);

		/*************************************************/

		
		/***************** My Passengers *****************/
		lblMyPsg = new JLabel("My Passengers");
		lblMyPsg.setBounds(10, 105, 150, 20);
		add(lblMyPsg);

		pnlInScroll = new JPanel();
		pnlInScroll.setLayout(new GridLayout(0, 1, 0, 0));
		pnlInScroll.setBackground(SystemColor.window);
		pnlInScroll.add(new ComponentCreateNewPassenger(pnlInScroll, c));
		new ShowPassenger(pnlInScroll, c);

		scPMyPsg = new JScrollPane(pnlInScroll);
		scPMyPsg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		scPMyPsg.setBounds(5, 130, 570, 250);
		add(scPMyPsg);
	}

	private class saveInfoLisetener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String oldPhone = lblPhoneValue.getText();
			String newPhone = txtPhoneValue.getText();
			String oldEmail = lblEmailValue.getText();
			String newEmail = txtEmailValue.getText();
			if (newPhone.equals(oldPhone)) {
				newPhone = phone;
			}
			if (newEmail.equals(oldEmail)) {
				newEmail = email;
			}
			ClientDAO.updateInfo(client.getCid(), newPhone, newEmail);
			client = ClientDAO.getClient(cid);
			cid = client.getCid();
			phone = client.getPhone();
			email = client.getEmail();

			lblPhoneValue.setText(phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4));
			lblEmailValue.setText(email.substring(0, 1) + "****" + email.substring(email.length() - 5));

			lblPhoneValue.setVisible(true);
			lblEmailValue.setVisible(true);
			btnMIEdit.setVisible(true);

			btnMISave.setVisible(false);
			txtPhoneValue.setVisible(false);
			txtEmailValue.setVisible(false);
		}
	}

	public TabSettings getFatherTab() {
		return fatherTab;
	}

	public void setFatherTab(TabSettings fatherTab) {
		this.fatherTab = fatherTab;
	}
}
