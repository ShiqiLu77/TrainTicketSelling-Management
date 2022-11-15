package com.shiqi.pojo;

public class Seat {
	private String seatID;
	private String carriage;
	private String row;
	private String column;
	private String seatType;
	
	private String priceBase;
	private String status;
	private String date;
	private String trainID;
	

	public Seat(String seatID, String date, String trainID, String carriage, String row, String column, 
				String seatType, String priceBase, String status) {
		super();
		this.seatID = seatID;
		this.carriage = carriage;
		this.row = row;
		this.column = column;
		this.seatType = seatType;
		
		this.priceBase = priceBase;
		this.status = status;
		this.date = date;
		this.trainID = trainID;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
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

	public String getPriceBase() {
		return priceBase;
	}

	public void setPriceBase(String priceBase) {
		this.priceBase = priceBase;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
