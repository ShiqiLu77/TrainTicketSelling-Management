package com.shiqi.guiCstm;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.shiqi.pojo.Client;

public class TabSettings extends JPanel {
	private Client client;
	private JTabbedPane fathertabbedPane;
	private JPanel pnlDeafult;
	private JPanel pnlMyInfo;
	private JPanel pnlMyPsg;


	public TabSettings(LayoutManager layout,Client c) {
		super(layout);
		pnlDeafult = new PanelSettingsDefault(this,c);

		add(pnlDeafult);
	}

	public JPanel getPnlDeafult() {
		return pnlDeafult;
	}

	public void setPnlDeafult(JPanel pnlDeafult) {
		this.pnlDeafult = pnlDeafult;
	}

	public JPanel getPnlMyInfo() {
		return pnlMyInfo;
	}

	public void setPnlMyInfo(JPanel pnlMyInfo) {
		this.pnlMyInfo = pnlMyInfo;
	}

	public JPanel getPnlMyPsg() {
		return pnlMyPsg;
	}

	public void setPnlMyPsg(JPanel pnlMyPsg) {
		this.pnlMyPsg = pnlMyPsg;
	}

	public JTabbedPane getFathertabbedPane() {
		return fathertabbedPane;
	}

	public void setFathertabbedPane(JTabbedPane fathertabbedPane) {
		this.fathertabbedPane = fathertabbedPane;
	}

}
