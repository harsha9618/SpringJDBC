package com.hr.sg.pojo;

public class Employee {
	private int eid;
	private String ename;
	private String email;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(int eid, String ename, String email) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
	}

	@Override
	public String toString() {
		return  this.eid+"  "+this.ename+"  "+this.email;
	}

}
