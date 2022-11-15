package com.shiqi.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;

import com.shiqi.pojo.Passenger;

public class PassengerSelectedListener implements ItemListener {

	private ArrayList<String> pIDs;
	private JCheckBox box;

	public PassengerSelectedListener(ArrayList<String> pIDs, JCheckBox box) {
		super();
		this.pIDs = pIDs;
		this.box = box;
	}

	public void itemStateChanged(ItemEvent e) {
		if (box.isSelected()) {
			pIDs.add(box.getName());
		} else {
			pIDs.remove(box.getName());
		}
	}
}
