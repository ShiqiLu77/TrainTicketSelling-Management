package com.shiqi.pojo;

public class Ticket {
	private String ticketNumberString;
	private String passengerID;
//	private String fromStationID;
//	private String toStationID;
	private String seatID;
//	private String status;
	
	private String passengerName;
	private String date;
	private String trainID;
	private String carriage;
	private String row;
	private String column;
	private String seatType;
	private String fromCity;
	private String toCity;
	private String fromStation;
	private String toStation;
	private String leaveTime;
	private String arriveTime;
	private String duration;
	private String price;
	private String statusString;

	public Ticket(String ticketNumberString, String passengerID, String passengerName,String date, String trainID, String carriage,
			String row, String column, String seatType, String fromCity, String toCity, String fromStation,
			String toStation, String leaveTime, String arriveTime, String duration, String price, String statusString,String seatID) {
		super();
		this.ticketNumberString = ticketNumberString;
		this.passengerID = passengerID;
		this.passengerName = passengerName;
		this.date = date;
		this.trainID = trainID;
		this.carriage = carriage;
		this.row = row;
		this.column = column;
		this.seatType = seatType;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.leaveTime = leaveTime;
		this.arriveTime = arriveTime;
		this.duration = duration;
		this.price = price;
		this.statusString = statusString;
		this.seatID = seatID;
	}

	public String getTicketNumberString() {
		return ticketNumberString;
	}

	public void setTicketNumberString(String ticketNumberString) {
		this.ticketNumberString = ticketNumberString;
	}

	public String getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTrainID() {
		return trainID;
	}

	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}

	public String getCarriage() {
		return carriage;
	}

	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

}
