package com.shiqi.utility;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.shiqi.DAOCstm.TrainDAO;
import com.shiqi.guiCstm.ComponentAvailableTrain;
import com.shiqi.guiCstm.TabBook;
import com.shiqi.pojo.Train;
import com.shiqi.pojo.Client;

public class SearchAvaliableTrain {

	private ArrayList<Train> trains;

	public SearchAvaliableTrain(TabBook tab, JPanel fPanel, Client c, String date, String from, String to) {
		trains = TrainDAO.getAvaliableTrains(date, from, to);
		
		int n = 0;// count component numbers
		for (Train t : trains) {
			n = n + 1;
			ComponentAvailableTrain train = new ComponentAvailableTrain(tab, fPanel, c, date, t);
			fPanel.add(train);
		}
		int height = (ComponentAvailableTrain.HEIGHT + 2) * n;
		fPanel.setPreferredSize(new Dimension(0, height));

	}
}
