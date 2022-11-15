package com.shiqi.guiCstm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.shiqi.DAOCstm.ClientDAO;
import com.shiqi.listener.ClientLoginActionListener;
import com.shiqi.listener.ManagerLoginActionListener;
import com.shiqi.utility.SetDeaultText;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class FrameLogin extends JFrame {
	private JLabel lblUN;
	private JLabel lblPw;
	private JLabel lblInfo;
	private JTextField txtUN;
	private JTextField txtUNR;
	private JButton btnLogin;
	private JButton btnExit;
	private JPasswordField pwF;
	private JPasswordField pwFR;
	private JButton btnRegister;
	private JButton btnConfirm;
	private JSeparator separator;
	private JLabel lblRegister;
	
	private JTextField txtMN;
	private JPasswordField pwFM;
	private JLabel lblInfoM;

	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(500, 250, 520, 370);
		
		JTabbedPane tabbedPane = new JTabbedPane();

		JComponent tabClient  = new JPanel();
		tabClient.setLayout(null);
		tabbedPane.addTab("client", null, tabClient, "Some tips");

		JComponent tabManager = new JPanel();
		tabManager.setLayout(null);
		tabbedPane.addTab("Manager", null, tabManager, "Some tips");

		getContentPane().add(tabbedPane);
		
		/*******client*******/
		btnLogin = new JButton("Login");
		btnLogin.setBounds(170, 158, 160, 35);
		btnLogin.addActionListener(new ClientLoginActionListener(this));
		tabClient.add(btnLogin);

		btnConfirm = new JButton("confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUNR.getText();
				String password = new String(pwFR.getPassword());
				if (username.equals("") || password.equals("")) {
					lblInfo.setText("please enter need infomation to register!");
				} else {
					if (ClientDAO.chectClientExist(username)) {
						lblInfo.setText("Username already exist. Please change your username");
					} else {
						ClientDAO.createClient(username, password);
						lblRegister.setText("Register successful. Please use your username and password to login");
						lblInfo.setText("");
						txtUN.setVisible(true);
						txtUN.setText("");
						pwF.setVisible(true);
						pwF.setText("");
						btnRegister.setVisible(true);
						btnLogin.setVisible(true);
						separator.setVisible(true);

						btnConfirm.setVisible(false);
						txtUNR.setVisible(false);
						pwFR.setVisible(false);
					}
				}
			}
		});
		btnConfirm.setBounds(170, 158, 160, 35);
		btnConfirm.setVisible(false);
		tabClient.add(btnConfirm);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(170, 195, 160, 35);
		tabClient.add(btnExit);

		txtUN = new JTextField();
		txtUN.setBounds(160, 53, 245, 35);
		tabClient.add(txtUN);

		pwF = new JPasswordField();
		pwF.setBounds(160, 95, 245, 35);
		tabClient.add(pwF);
		
		txtUNR = new JTextField();
		txtUNR.setBounds(160, 53, 245, 35);
		txtUNR.setVisible(false);
		tabClient.add(txtUNR);

		pwFR = new JPasswordField();
		pwFR.setBounds(160, 95, 245, 35);
		pwFR.setVisible(false);
		tabClient.add(pwFR);

		lblPw = new JLabel("Password");
		lblPw.setBounds(85, 100, 80, 25);
		tabClient.add(lblPw);

		lblUN = new JLabel("User Name");
		lblUN.setBounds(85, 58, 80, 25);
		tabClient.add(lblUN);

		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(new Color(255, 51, 51));
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblInfo.setBounds(100, 135, 310, 20);
		tabClient.add(lblInfo);

		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUN.setVisible(false);
				pwF.setVisible(false);
				btnRegister.setVisible(false);
				btnLogin.setVisible(false);
				separator.setVisible(false);

				btnConfirm.setVisible(true);
				txtUNR.setVisible(true);
				txtUNR.setText("");
				pwFR.setVisible(true);
				pwFR.setText("");
				lblRegister.setText("Please set your name and password");
			}
		});
		btnRegister.setBounds(170, 240, 160, 35);
		tabClient.add(btnRegister);

		separator = new JSeparator();
		separator.setBounds(170, 230, 160, 12);
		tabClient.add(separator);

		lblRegister = new JLabel("");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.GRAY);
		lblRegister.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		lblRegister.setBounds(100, 35, 310, 20);
		tabClient.add(lblRegister);
		
		JLabel lblNewLabel = new JLabel("Writen by @Lushiqi");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 280, 200, 16);
		tabClient.add(lblNewLabel);
		
		
		/******* manager ********/
		JButton btnLoginM = new JButton("Login");
		btnLoginM.setBounds(170, 158, 160, 35);
		btnLoginM.addActionListener(new ManagerLoginActionListener(this));
		tabManager.add(btnLoginM);

		JButton btnExitM = new JButton("Exit");
		btnExitM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitM.setBounds(170, 195, 160, 35);
		tabManager.add(btnExitM);

		txtMN = new JTextField();
		txtMN.setBounds(160, 53, 245, 35);
		tabManager.add(txtMN);

		pwFM = new JPasswordField();
		pwFM.setBounds(160, 95, 245, 35);
		tabManager.add(pwFM);

		JLabel lblPwM = new JLabel("Password");
		lblPwM.setBounds(85, 100, 80, 25);
		tabManager.add(lblPwM);

		JLabel lblMN = new JLabel("User Name");
		lblMN.setBounds(85, 58, 80, 25);
		tabManager.add(lblMN);

		lblInfoM = new JLabel("");
		lblInfoM.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoM.setForeground(new Color(255, 51, 51));
		lblInfoM.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblInfoM.setBounds(100, 135, 310, 20);
		tabManager.add(lblInfoM);
	}

	public JTextField getTxtUN() {
		return txtUN;
	}

	public void setTxtUN(JTextField txtUN) {
		this.txtUN = txtUN;
	}

	public JPasswordField getPwF() {
		return pwF;
	}

	public void setPwF(JPasswordField pwF) {
		this.pwF = pwF;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}

	public void setLblInfo(JLabel lblInfo) {
		this.lblInfo = lblInfo;
	}

	public JTextField getTxtMN() {
		return txtMN;
	}

	public void setTxtMN(JTextField txtMN) {
		this.txtMN = txtMN;
	}

	public JPasswordField getPwFM() {
		return pwFM;
	}

	public void setPwFM(JPasswordField pwFM) {
		this.pwFM = pwFM;
	}

	public JLabel getLblInfoM() {
		return lblInfoM;
	}

	public void setLblInfoM(JLabel lblInfoM) {
		this.lblInfoM = lblInfoM;
	}
}
