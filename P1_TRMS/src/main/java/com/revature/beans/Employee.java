package com.revature.beans;

public class Employee {
	private int emp_id;
	private String fName;
	private String lName;
	private String deptName;
	private String user;
	private String pw;
	private double TotalReimbursements;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String fName, String lName, String deptName, String user, String pw,
			double totalReimbursements) {
		super();
		this.emp_id = emp_id;
		this.fName = fName;
		this.lName = lName;
		this.deptName = deptName;
		this.user = user;
		this.pw = pw;
		TotalReimbursements = totalReimbursements;
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

	public double getTotalReimbursements() {
		return TotalReimbursements;
	}

	public void setTotalReimbursements(double totalReimbursements) {
		TotalReimbursements = totalReimbursements;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", fName=" + fName + ", lName=" + lName + ", deptName=" + deptName
				+ ", user=" + user + ", pw=" + pw + ", TotalReimbursements=" + TotalReimbursements + "]";
	}

}
