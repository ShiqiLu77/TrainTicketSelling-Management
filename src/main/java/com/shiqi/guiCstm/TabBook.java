package com.shiqi.guiCstm;

import java.awt.LayoutManager;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.shiqi.pojo.Client;

public class TabBook extends JPanel {
	private Client client;

	private JDialog fatherFrame;
	private JPanel pnlDeafult;
	private JPanel pnlSearch;

	public TabBook(JDialog fFrame, Client c) {
		super(null);
		fatherFrame = fFrame;
		client = c;
		pnlDeafult = new PanelBookDefault(this);

		add(pnlDeafult);
	}

	public JPanel getPnlDeafult() {
		return pnlDeafult;
	}

	public void setPnlDeafult(JPanel pnlDeafult) {
		this.pnlDeafult = pnlDeafult;
	}

	public JPanel getPnlSearch() {
		return pnlSearch;
	}

	public void setPnlSearch(JPanel pnlSearch) {
		this.pnlSearch = pnlSearch;
	}

	public JDialog getFatherFrame() {
		return fatherFrame;
	}

	public void setFatherFrame(JDialog fatherFrame) {
		this.fatherFrame = fatherFrame;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
