package com.revature.beans;

public class Supervisor {
	private int emp_id;
	private String fName;
	private String lName;
	private String deptName;
	private String user;
	private String pw;
	private boolean isDeptHead;

	public Supervisor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supervisor(int emp_id, String fName, String lName, String deptName, String user, String pw,
			boolean isDeptHead) {
		super();
		this.emp_id = emp_id;
		this.fName = fName;
		this.lName = lName;
		this.deptName = deptName;
		this.user = user;
		this.pw = pw;
		this.isDeptHead = isDeptHead;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public boolean isDeptHead() {
		return isDeptHead;
	}

	public void setDeptHead(boolean isDeptHead) {
		this.isDeptHead = isDeptHead;
	}

	@Override
	public String toString() {
		return "Supervisor [emp_id=" + emp_id + ", fName=" + fName + ", lName=" + lName + ", deptName=" + deptName
				+ ", user=" + user + ", pw=" + pw + ", isDeptHead=" + isDeptHead + "]";
	}

}
