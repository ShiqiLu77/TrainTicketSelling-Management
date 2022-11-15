package com.shiqi.pojo;

public class Train {
	private String tcID;
	private String date;
	private String trainID;
	private String traintype;
	private String traintypeID;
	private String fromCity;
	private String toCity;
	private String fromStation;
	private String toStation;
	private String duration;
	private String leaveTime;
	private String arriveTime;
	private String fromTPSID;
	private String toTPSID;
	private String distance;
	private String priceBase;

	public Train(String tcID,String date, String trainID, String traintype, String traintypeID, String fromCity,
			String toCity, String fromStation, String toStation, String duration, String leaveTime, String arriveTime,
			String fromTPSID, String toTPSID,String distance, String priceBase) {
		super();
		this.tcID = tcID;
		this.date = date;
		this.trainID = trainID;
		this.traintype = traintype;
		this.traintypeID = traintypeID;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.duration = duration;
		this.leaveTime = leaveTime;
		this.arriveTime = arriveTime;
		this.fromTPSID = fromTPSID;
		this.toTPSID = toTPSID;
		this.distance = distance;
		this.priceBase = priceBase;
	}

	public String getPriceBase() {
		return priceBase;
	}

	public void setPriceBase(String priceBase) {
		this.priceBase = priceBase;
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

	public String getTraintype() {
		return traintype;
	}

	public void setTraintype(String traintype) {
		this.traintype = traintype;
	}

	public String getTraintypeID() {
		return traintypeID;
	}

	public void setTraintypeID(String traintypeID) {
		this.traintypeID = traintypeID;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public String getFromTPSID() {
		return fromTPSID;
	}

	public void setFromTPSID(String fromTPSID) {
		this.fromTPSID = fromTPSID;
	}

	public String getToTPSID() {
		return toTPSID;
	}

	public void setToTPSID(String toTPSID) {
		this.toTPSID = toTPSID;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getTcID() {
		return tcID;
	}

	public void setTcID(String tcID) {
		this.tcID = tcID;
	}

}
