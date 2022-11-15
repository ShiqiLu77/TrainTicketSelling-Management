package com.shiqi.guiCstm;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import com.shiqi.pojo.Client;
import com.shiqi.utility.SearchAvaliableTrain;

import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelBookSearch extends JPanel {
	private Client client;
	
	private TabBook fatherTab;
	private JLabel lblFrom;
	private JLabel lblTo;
	private JLabel lblDate;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtDate;
	private JButton btnSearch;
	private JPanel pnlInScroll1;
	private JScrollPane scrollPane;
	
	private String date;
	private String from;
	private String to;


	public PanelBookSearch(TabBook tab, Client c, String date, String from, String to) {
		this.client = c;
		this.date = date;
		this.from = from;
		this.to = to;
		fatherTab = tab;
		setLayout(null);
		setBounds(0, 0, 580, 380);

		lblFrom = new JLabel("From");
		lblFrom.setBounds(7, 5, 40, 35);
		add(lblFrom);

		lblTo = new JLabel("To");
		lblTo.setBounds(155, 5, 20, 35);
		add(lblTo);

		lblDate = new JLabel("Date");
		lblDate.setBounds(328, 5, 40, 35);
		add(lblDate);

		txtFrom = new JTextField(from);
		txtFrom.setBounds(40, 5, 110, 35);
		add(txtFrom);
		txtFrom.setColumns(10);

		txtTo = new JTextField(to);
		txtTo.setHorizontalAlignment(SwingConstants.LEFT);
		txtTo.setBounds(170, 5, 110, 35);
		add(txtTo);
		txtTo.setColumns(10);

		txtDate = new JTextField(date);
		txtDate.setBounds(364, 5, 95, 35);
		add(txtDate);
		txtDate.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				pnlInScroll1.removeAll();
				pnlInScroll1.repaint();
				new SearchAvaliableTrain(fatherTab ,pnlInScroll1, client,txtDate.getText(),txtFrom.getText() ,txtTo.getText());
				pnlInScroll1.revalidate();
			}
		});
		btnSearch.setBounds(480, 8, 100, 30);
		add(btnSearch);

		pnlInScroll1 = new JPanel();
		pnlInScroll1.setLayout(new GridLayout(0, 1, 0, 0));
		pnlInScroll1.setBackground(Color.WHITE);
		new SearchAvaliableTrain(tab ,pnlInScroll1, client,date,from ,to);

		scrollPane = new JScrollPane(pnlInScroll1);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		scrollPane.setBounds(5, 45, 570, 330);
		add(scrollPane);
	}
}
