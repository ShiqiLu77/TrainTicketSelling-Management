package com.shiqi.pojo;

public class Passenger {
	private String pid;
	private String fname;
	private String lname;
	
	public Passenger(String pid, String fname, String lname) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String id) {
		this.pid = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

}
