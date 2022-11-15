package com.shiqi.guiCstm;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.shiqi.pojo.Client;

public class TabMyTicket extends JPanel {
	private Client c;
	private JTabbedPane fathertabbedPane;
	private PanelMyTicketDefault pnlDeafult;
	private JPanel pnlUsedTikets;

	public TabMyTicket(LayoutManager layout, Client c, JTabbedPane tabbedPane) {
		super(layout);
		fathertabbedPane = tabbedPane;
		pnlDeafult = new PanelMyTicketDefault(this,c);
		pnlUsedTikets = new PanelMyTicketUsedTiket(this,c);

		add(pnlDeafult);
		add(pnlUsedTikets);
		pnlUsedTikets.setVisible(false);
	}

	public PanelMyTicketDefault getPnlDeafult() {
		return pnlDeafult;
	}

	public void setPnlDeafult(PanelMyTicketDefault pnlDeafult) {
		this.pnlDeafult = pnlDeafult;
	}

	public JPanel getPnlUsedTikets() {
		return pnlUsedTikets;
	}

	public void setPnlUsedTikets(JPanel pnlUsedTikets) {
		this.pnlUsedTikets = pnlUsedTikets;
	}

	public JTabbedPane getFathertabbedPane() {
		return fathertabbedPane;
	}

	public void setFathertabbedPane(JTabbedPane fathertabbedPane) {
		this.fathertabbedPane = fathertabbedPane;
	}


}
