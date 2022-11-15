package com.shiqi.guiMng;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.shiqi.pojo.Manager;

public class FrameManagerMain extends JDialog {
	private JTabbedPane tabbedPane;
	private JComponent tabHome;
	private JComponent tabInfo;
	private JComponent tabOther;
	private JMenuBar menuBar;
	private JMenu mnTrain;
	private JMenuItem mnNewTrain;

	/**
	 * Create the frame.
	 */
	public FrameManagerMain(Manager m) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(350, 80, 800, 520);
		setVisible(true);

		tabbedPane = new JTabbedPane();
		
		/***** Home ****/
		tabHome = new PaneHome(m);
		tabbedPane.addTab("Home", null, tabHome, "Some tips");
		
		/***** Information pane ****/
		tabInfo = new PaneInfo(m);
		tabbedPane.addTab("Infomation Pane", null, tabInfo, "Some tips");
		
		/***** other ****/
		tabOther = new JPanel();
		tabbedPane.addTab("Others", null, tabOther, "Some tips");

		getContentPane().add(tabbedPane);
	}
}
