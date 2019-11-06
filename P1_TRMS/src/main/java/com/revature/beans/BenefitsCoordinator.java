package com.revature.beans;

public class BenefitsCoordinator {
	private int emp_id;
	private String fName;
	private String lName;
	private String user;
	private String pw;

	public BenefitsCoordinator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BenefitsCoordinator(int emp_id, String fName, String lName, String user, String pw) {
		super();
		this.emp_id = emp_id;
		this.fName = fName;
		this.lName = lName;
		this.user = user;
		this.pw = pw;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
		return "BenefitsCoordinator [emp_id=" + emp_id + ", fName=" + fName + ", lName=" + lName + ", user=" + user
				+ ", pw=" + pw + "]";
	}

}
