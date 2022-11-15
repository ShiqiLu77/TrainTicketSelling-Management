package com.shiqi.utility;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class SetDeaultText {
	private JTextField txtField;
	private String defaultTxt;

	public SetDeaultText(JTextField textField, String defaultText) {
		this.txtField = textField;
		this.defaultTxt = defaultText;

		txtField.setText(defaultTxt);
		txtField.setForeground(Color.lightGray);
		txtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtField.getForeground() == (Color.lightGray)) {
					txtField.setText("");
					txtField.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtField.getText().equals("")) {
					txtField.setForeground(Color.lightGray);
					txtField.setText(defaultTxt);
				}
			}
		});
	}
}
