package com.shiqi.guiCstm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.shiqi.listener.CreatePassengerUnderClientListener;
import com.shiqi.pojo.Client;
import com.shiqi.utility.SetDeaultText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentCreateNewPassenger extends JPanel {
	public static int HEIGHT = 60;
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtID;

	public ComponentCreateNewPassenger(JPanel fpanel, Client c) {
		setLayout(null);
		setSize(new Dimension(570, HEIGHT));
		setBorder(new LineBorder(new Color(230, 230, 230), 1, true));
		setBackground(Color.WHITE);

		btnAdd = new JButton("Click to add new passenger");
		btnAdd.setBounds(0, 0, 565, HEIGHT);
		btnAdd.setBorder(null);
		btnAdd.setForeground(Color.LIGHT_GRAY);
		btnAdd.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 12));
		btnAdd.addActionListener(new AddPassengerLisetener());
		add(btnAdd);

		txtFName = new JTextField();
		txtFName.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		txtFName.setBounds(15, HEIGHT / 6, 125, HEIGHT / 3 + 5);
		txtFName.setVisible(false);
		add(txtFName);
		new SetDeaultText(txtFName, "First name");

		txtLName = new JTextField();
		txtLName.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		txtLName.setBounds(140, HEIGHT / 6, 125, HEIGHT / 3 + 5);
		txtLName.setVisible(false);
		add(txtLName);
		new SetDeaultText(txtLName, "Last name");

		txtID = new JTextField();
		txtID.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtID.setBounds(15, HEIGHT / 2 + 10, 125, HEIGHT / 4);
		txtID.setVisible(false);
		add(txtID);
		new SetDeaultText(txtID, "ID number");

		btnSave = new JButton("Save");
		btnSave.setBounds(435, HEIGHT / 4, 110, HEIGHT / 2);
		btnSave.addActionListener(new CreatePassengerUnderClientListener(fpanel, this, c));
		btnSave.setVisible(false);
		add(btnSave);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(325, HEIGHT / 4, 110, HEIGHT / 2);
		btnCancel.addActionListener(new CancelSavingPassengerLisetener());
		btnCancel.setVisible(false);
		add(btnCancel);

	}

	private class AddPassengerLisetener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnAdd.setVisible(false);

			txtFName.setVisible(true);
			new SetDeaultText(txtFName, "First name");
			txtLName.setVisible(true);
			new SetDeaultText(txtLName, "Last name");
			txtID.setVisible(true);
			new SetDeaultText(txtID, "ID number");
			btnSave.setVisible(true);
			btnCancel.setVisible(true);
		}
	}

	private class CancelSavingPassengerLisetener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnAdd.setVisible(true);

			txtFName.setVisible(false);
			txtLName.setVisible(false);
			txtID.setVisible(false);
			btnSave.setVisible(false);
			btnCancel.setVisible(false);
		}
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JTextField getTxtFName() {
		return txtFName;
	}

	public void setTxtFName(JTextField txtFName) {
		this.txtFName = txtFName;
	}

	public JTextField getTxtLName() {
		return txtLName;
	}

	public void setTxtLName(JTextField txtLName) {
		this.txtLName = txtLName;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}
}
