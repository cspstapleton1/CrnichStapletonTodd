package com.revature.beans;

public class BenefitsCoordinator {
	private int bc_id;
	private String fName;
	private String lName;
	private String user;
	private String pw;

	public BenefitsCoordinator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BenefitsCoordinator(int bc_id, String fName, String lName, String user, String pw) {
		super();
		this.bc_id = bc_id;
		this.fName = fName;
		this.lName = lName;
		this.user = user;
		this.pw = pw;
	}

	public int getBc_id() {
		return bc_id;
	}

	public void setBc_id(int bc_id) {
		this.bc_id = bc_id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "BenefitsCoordinator [bc_id=" + bc_id + ", fName=" + fName + ", lName=" + lName + ", user=" + user
				+ ", pw=" + pw + "]";
	}

}
