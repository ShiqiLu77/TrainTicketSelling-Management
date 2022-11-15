package com.shiqi.utility;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.shiqi.DAOCstm.SeatDAO;
import com.shiqi.DAOCstm.TicketDAO;
import com.shiqi.guiCstm.DialogTicketDetail;
import com.shiqi.guiCstm.DialogTicketPay;
import com.shiqi.pojo.Train;
import com.shiqi.pojo.Client;
import com.shiqi.pojo.Seat;
import com.shiqi.pojo.Ticket;

public class GetTicket {
	private ArrayList<Seat> preferredSeats;
	private ArrayList<Seat> otherSeats;

	public GetTicket(DialogTicketDetail ticketDetailDialog, Client client, Train t, String selectedSeatType,
			ArrayList<String> selectedPID, ArrayList<String> preferredLocation) {
		int nPsg = selectedPID.size();// the number of passengers
		System.out.println("need passengers " + nPsg);

		int nTic = 0;
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		/***** confirm seat id *****/

		preferredSeats = SeatDAO.getPreferredSeat(t.getDate(), t.getTrainID(), selectedSeatType, nPsg, preferredLocation);
		nTic = preferredSeats.size();
		System.out.println("get prefereed seat " + nTic);

		// step2 get other available seat
		if (nTic < nPsg) {
			otherSeats = SeatDAO.getSeat(t.getDate(), t.getTrainID(), selectedSeatType, nPsg - nTic);
			nTic = nTic + otherSeats.size();
		}

		// step3 if available seat is not enough
		if (nTic < nPsg) {
			JOptionPane.showMessageDialog(null, "No enough seat left. Please reduce the number of passengers", "No ticket left enough", JOptionPane.PLAIN_MESSAGE);
		} else {
			// step4 seat is enough
			String[] pids = new String[nPsg];
			int j = 0;
			for (String pid : selectedPID) {
				pids[j] = pid;
				j++;
			}

			int k = 0;
			for (Seat s : preferredSeats) {
				tickets.add(TicketDAO.generateTicket(pids[k], t.getFromTPSID(), t.getToTPSID(), s.getSeatID()));
				k++;
			}
			new DialogTicketPay(client,tickets);
			ticketDetailDialog.dispose();
		}
		/****************************/

	}

}
