package com.shiqi.guiCstm;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import com.shiqi.listener.PreferredLocationSelectedListener;

import javax.swing.event.ChangeEvent;

public class ComponentPreferedSeatLocation extends JPanel {
	private ArrayList<String> preferredseatLocation;
	private JPanel pnlBerth2;
	private JPanel pnlBerth3;
	private JPanel pnlSeat4;
	private JPanel pnlSeat5;

	private JCheckBox b2u;
	private JCheckBox b2l;
	private JCheckBox b3u;
	private JCheckBox b3d;
	private JCheckBox b3l;
	private JCheckBox s4w1;
	private JCheckBox s4w2;
	private JCheckBox s4a1;
	private JCheckBox s4a2;
	private JCheckBox s5w1;
	private JCheckBox s5w2;
	private JCheckBox s5m;
	private JCheckBox s5a1;
	private JCheckBox s5a2;

	public ComponentPreferedSeatLocation(String seattype,ArrayList<String> preferredLocation) {
		setBackground(Color.WHITE);
		this.preferredseatLocation = preferredLocation;
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setLayout(null);
		setSize(450, 85);

		JLabel lblInfo = new JLabel("Seating Chart");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblInfo.setForeground(Color.LIGHT_GRAY);
		lblInfo.setBounds(20, 10, 400, 15);
		add(lblInfo);

		/*********** berth ************/
		/*** berth 2 **/
		JLabel lblCelling = new JLabel("Ceiling");
		lblCelling.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelling.setForeground(Color.LIGHT_GRAY);
		lblCelling.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblCelling.setBounds(20, 20, 60, 20);

		JLabel lblFloor = new JLabel("Floor");
		lblFloor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFloor.setForeground(Color.LIGHT_GRAY);
		lblFloor.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblFloor.setBounds(370, 20, 60, 20);

		pnlBerth2 = new JPanel();
		pnlBerth2.setLayout(null);
		pnlBerth2.setBounds(1, 20, 448, 55);
		pnlBerth2.setBackground(Color.WHITE);
		add(pnlBerth2);
		pnlBerth2.add(lblCelling);
		pnlBerth2.add(lblFloor);

		b2u = new JCheckBox("U");
		b2u.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, b2u));
		b2u.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		b2u.setBounds(130, 20, 45, 20);
		pnlBerth2.add(b2u);
		b2u.setName("1");

		b2l = new JCheckBox("L");
		b2l.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, b2l));
		b2l.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		b2l.setBounds(275, 20, 45, 20);
		pnlBerth2.add(b2l);
		b2l.setName("2");

		/*** berth 3 **/
		JLabel lblCelling3 = new JLabel("Ceiling");
		lblCelling3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelling3.setForeground(Color.LIGHT_GRAY);
		lblCelling3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblCelling3.setBounds(20, 20, 60, 20);

		JLabel lblFloor3 = new JLabel("Floor");
		lblFloor3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFloor3.setForeground(Color.LIGHT_GRAY);
		lblFloor3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblFloor3.setBounds(370, 20, 60, 20);

		pnlBerth3 = new JPanel();
		pnlBerth3.setLayout(null);
		pnlBerth3.setBounds(1, 20, 448, 55);
		pnlBerth3.setBackground(Color.WHITE);
		add(pnlBerth3);

		pnlBerth3.add(lblCelling3);
		pnlBerth3.add(lblFloor3);

		b3u = new JCheckBox("U");
		b3u.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, b3u));
		b3u.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		b3u.setBounds(110, 20, 45, 20);
		pnlBerth3.add(b3u);
		b3u.setName("1");

		b3d = new JCheckBox("D");
		b3d.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, b3d));
		b3d.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		b3d.setBounds(202, 20, 47, 20);
		pnlBerth3.add(b3d);
		b3d.setName("2");

		b3l = new JCheckBox("L");
		b3l.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, b3l));
		b3l.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		b3l.setBounds(295, 20, 45, 20);
		pnlBerth3.add(b3l);
		b3l.setName("3");
		/******************************/

		/*********** seat ************/
		JLabel lblAisle = new JLabel("Aisle");
		lblAisle.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblAisle.setForeground(Color.LIGHT_GRAY);
		lblAisle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAisle.setBounds(205, 20, 40, 20);

		JLabel lblWindow1 = new JLabel("Window");
		lblWindow1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindow1.setForeground(Color.LIGHT_GRAY);
		lblWindow1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblWindow1.setBounds(20, 20, 60, 20);

		JLabel lblWindow2 = new JLabel("Window");
		lblWindow2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindow2.setForeground(Color.LIGHT_GRAY);
		lblWindow2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblWindow2.setBounds(370, 20, 60, 20);

		/**** seat4 ****/
		pnlSeat4 = new JPanel();
		pnlSeat4.setLayout(null);
		pnlSeat4.setBounds(1, 20, 448, 55);
		pnlSeat4.setBackground(Color.WHITE);
		add(pnlSeat4);
		pnlSeat4.add(lblAisle);
		pnlSeat4.add(lblWindow1);
		pnlSeat4.add(lblWindow2);

		s4w1 = new JCheckBox("W");
		s4w1.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s4w1));
		s4w1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s4w1.setBounds(90, 20, 45, 20);
		pnlSeat4.add(s4w1);
		s4w1.setName("1");

		s4a1 = new JCheckBox("A");
		s4a1.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s4a1));
		s4a1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s4a1.setBounds(130, 20, 45, 20);
		pnlSeat4.add(s4a1);
		s4a1.setName("2");

		s4a2 = new JCheckBox("A");
		s4a2.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s4a2));
		s4a2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s4a2.setBounds(255, 20, 45, 20);
		pnlSeat4.add(s4a2);
		s4a2.setName("3");

		s4w2 = new JCheckBox("W");
		s4w2.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s4w2));
		s4w2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s4w2.setBounds(313, 20, 45, 20);
		pnlSeat4.add(s4w2);
		s4w2.setName("4");

		/**** seat5 ****/

		JLabel lblAisle5 = new JLabel("Aisle");
		lblAisle5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblAisle5.setForeground(Color.LIGHT_GRAY);
		lblAisle5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAisle5.setBounds(225, 20, 40, 20);

		JLabel lblWindow51 = new JLabel("Window");
		lblWindow51.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindow51.setForeground(Color.LIGHT_GRAY);
		lblWindow51.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblWindow51.setBounds(20, 20, 60, 20);

		JLabel lblWindow52 = new JLabel("Window");
		lblWindow52.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindow52.setForeground(Color.LIGHT_GRAY);
		lblWindow52.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 11));
		lblWindow52.setBounds(370, 20, 60, 20);

		pnlSeat5 = new JPanel();
		pnlSeat5.setLayout(null);
		pnlSeat5.setBounds(1, 20, 448, 55);
		pnlSeat5.setBackground(Color.WHITE);
		add(pnlSeat5);

		pnlSeat5.add(lblWindow51);
		pnlSeat5.add(lblWindow52);
		pnlSeat5.add(lblAisle5);

		s5w1 = new JCheckBox("W");
		s5w1.setName("1");
		s5w1.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s5w1));
		s5w1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s5w1.setBounds(90, 20, 45, 20);
		pnlSeat5.add(s5w1);

		s5m = new JCheckBox("M");
		s5m.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s5m));
		s5m.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s5m.setBounds(135, 20, 45, 20);
		pnlSeat5.add(s5m);
		s5m.setName("2");

		s5a1 = new JCheckBox("A");
		s5a1.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s5a1));
		s5a1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s5a1.setBounds(180, 20, 45, 20);
		pnlSeat5.add(s5a1);
		s5a1.setName("3");

		s5a2 = new JCheckBox("A");
		s5a2.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s5a2));
		s5a2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s5a2.setBounds(270, 20, 45, 20);
		pnlSeat5.add(s5a2);
		s5a2.setName("4");

		s5w2 = new JCheckBox("W");
		s5w2.addItemListener(new PreferredLocationSelectedListener(preferredseatLocation, s5w2));
		s5w2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		s5w2.setBounds(315, 20, 45, 20);
		s5w2.setName("5");
		pnlSeat5.add(s5w2);

		choosePnlToShow(seattype);
	}

	public void choosePnlToShow(String seattype) {
		if (seattype.equals("hard seat") || seattype.equals("second class seat")) {
			disSelectBox();
			pnlSeat5.setVisible(true);
			pnlSeat4.setVisible(false);
			pnlBerth2.setVisible(false);
			pnlBerth3.setVisible(false);
		} else if (seattype.equals("soft seat") || seattype.equals("first class seat")) {
			disSelectBox();
			pnlSeat5.setVisible(false);
			pnlSeat4.setVisible(true);
			pnlBerth2.setVisible(false);
			pnlBerth3.setVisible(false);
		} else if (seattype.equals("berth")) {
			disSelectBox();
			pnlSeat5.setVisible(false);
			pnlSeat4.setVisible(false);
			pnlBerth2.setVisible(false);
			pnlBerth3.setVisible(true);
		} else if (seattype.equals("cushioned berth")) {
			disSelectBox();
			pnlSeat5.setVisible(false);
			pnlSeat4.setVisible(false);
			pnlBerth2.setVisible(true);
			pnlBerth3.setVisible(false);
		}
	}

	private void disSelectBox() {
		b2u.setSelected(false);
		b2l.setSelected(false);
		b3u.setSelected(false);
		b3d.setSelected(false);
		b3l.setSelected(false);
		s4w1.setSelected(false);
		s4w2.setSelected(false);
		s4a1.setSelected(false);
		s4a2.setSelected(false);
		s5w1.setSelected(false);
		s5w2.setSelected(false);
		s5m.setSelected(false);
		s5a1.setSelected(false);
		s5a2.setSelected(false);
		if (preferredseatLocation != null) {
			preferredseatLocation.clear();
		}
	}
}
