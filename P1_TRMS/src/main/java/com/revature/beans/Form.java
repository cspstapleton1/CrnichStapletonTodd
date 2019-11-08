package com.revature.beans;

import java.sql.Time;
import java.io.File;
import java.sql.Date;

public class Form {
	private int form_id;
	private boolean urgent;
	private String event_type;
	private String fName;
	private String lName;
	private String dept;
	private String email;
	private String location;
	private String justification;
	private Date sDate;
	private Date eDate;
	private Time sTime;
	private Time eTime;
	private String gradeFormat;
	private String gradeCutoff;
	private double cost;
	private double reimbursement;
	private boolean presentation;
	private File attachment;
	private int sAccept = 0;
	private int dhAccept = 0;
	private int bcAccept = 0;
	private String failDesc;

	public Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Constructor for form without attachment
	public Form(int form_id, boolean urgent, String event_type, String fName, String lName, String dept, String email,
			String location, String justification, Date sDate, Date eDate, Time sTime, Time eTime, String gradeFormat,
			String gradeCutoff, double cost, double reimbursement, boolean presentation, int sAccept, int dhAccept,
			int bcAccept, String failDesc) {
		super();
		this.form_id = form_id;
		this.urgent = urgent;
		this.event_type = event_type;
		this.fName = fName;
		this.lName = lName;
		this.dept = dept;
		this.email = email;
		this.location = location;
		this.justification = justification;
		this.sDate = sDate;
		this.eDate = eDate;
		this.sTime = sTime;
		this.eTime = eTime;
		this.gradeFormat = gradeFormat;
		this.gradeCutoff = gradeCutoff;
		this.cost = cost;
		this.reimbursement = reimbursement;
		this.presentation = presentation;
		this.sAccept = sAccept;
		this.dhAccept = dhAccept;
		this.bcAccept = bcAccept;
		this.failDesc = failDesc;
	}
	
	// Constructor for form with an attachment
	public Form(int form_id, boolean urgent, String event_type, String fName, String lName, String dept, String email,
			String location, String justification, Date sDate, Date eDate, Time sTime, Time eTime, String gradeFormat,
			String gradeCutoff, double cost, double reimbursement, boolean presentation, File attachment, int sAccept,
			int dhAccept, int bcAccept, String failDesc) {
		super();
		this.form_id = form_id;
		this.urgent = urgent;
		this.event_type = event_type;
		this.fName = fName;
		this.lName = lName;
		this.dept = dept;
		this.email = email;
		this.location = location;
		this.justification = justification;
		this.sDate = sDate;
		this.eDate = eDate;
		this.sTime = sTime;
		this.eTime = eTime;
		this.gradeFormat = gradeFormat;
		this.gradeCutoff = gradeCutoff;
		this.cost = cost;
		this.reimbursement = reimbursement;
		this.presentation = presentation;
		this.attachment = attachment;
		this.sAccept = sAccept;
		this.dhAccept = dhAccept;
		this.bcAccept = bcAccept;
		this.failDesc = failDesc;
	}
	
	public int getForm_id() {
		return form_id;
	}

	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public Time getsTime() {
		return sTime;
	}

	public void setsTime(Time sTime) {
		this.sTime = sTime;
	}

	public Time geteTime() {
		return eTime;
	}

	public void seteTime(Time eTime) {
		this.eTime = eTime;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public String getGradeCutoff() {
		return gradeCutoff;
	}

	public void setGradeCutoff(String gradeCutoff) {
		this.gradeCutoff = gradeCutoff;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(double reimbursement) {
		this.reimbursement = reimbursement;
	}

	public boolean isPresentation() {
		return presentation;
	}

	public void setPresentation(boolean presentation) {
		this.presentation = presentation;
	}

	public int getsAccept() {
		return sAccept;
	}

	public void setsAccept(int sAccept) {
		this.sAccept = sAccept;
	}

	public int getDhAccept() {
		return dhAccept;
	}

	public void setDhAccept(int dhAccept) {
		this.dhAccept = dhAccept;
	}

	public int getBcAccept() {
		return bcAccept;
	}

	public void setBcAccept(int bcAccept) {
		this.bcAccept = bcAccept;
	}

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	public String getFailDesc() {
		return failDesc;
	}

	public void setFailDesc(String failDesc) {
		this.failDesc = failDesc;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	@Override
	public String toString() {
		return "Form [form_id=" + form_id + ", urgent=" + urgent + ", event_type=" + event_type + ", fName=" + fName
				+ ", lName=" + lName + ", dept=" + dept + ", email=" + email + ", location=" + location
				+ ", justification=" + justification + ", sDate=" + sDate + ", eDate=" + eDate + ", sTime=" + sTime
				+ ", eTime=" + eTime + ", gradeFormat=" + gradeFormat + ", gradeCutoff=" + gradeCutoff + ", cost="
				+ cost + ", reimbursement=" + reimbursement + ", presentation=" + presentation + ", attachment="
				+ attachment.getName() + ", sAccept=" + sAccept + ", dhAccept=" + dhAccept + ", bcAccept=" + bcAccept
				+ ", failDesc=" + failDesc + "]";
	}

}// End of Class Form
