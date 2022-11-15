package com.shiqi.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;

public class PreferredLocationSelectedListener implements ItemListener{
	private ArrayList<String> pLocations;
	private JCheckBox box;


	public PreferredLocationSelectedListener(ArrayList<String> pLocations, JCheckBox box) {
		super();
		this.pLocations = pLocations;
		this.box = box;
	}

	public void itemStateChanged(ItemEvent e) {
		if (box.isSelected()) {
			pLocations.add(box.getName());
		} else {
			pLocations.remove(box.getName());
		}
	}

}
