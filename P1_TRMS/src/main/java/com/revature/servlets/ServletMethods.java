package com.revature.servlets;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.revature.beans.BenefitsCoordinator;
import com.revature.beans.Employee;
import com.revature.beans.Supervisor;
import com.revature.daoImpl.BCDaoImpl;
import com.revature.daoImpl.EmployeeDaoImpl;
import com.revature.daoImpl.SupervisorDaoImpl;

public class ServletMethods {
	static BCDaoImpl bcdi = new BCDaoImpl();
	static EmployeeDaoImpl edi = new EmployeeDaoImpl();
	static SupervisorDaoImpl sdi = new SupervisorDaoImpl();
	
	public static Employee loginEmployee(String user, String password) {
		Employee e = new Employee();
		try {
			e = edi.login(user, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
	public static Supervisor loginSupervisor(String username, String password) {
		Supervisor s = new Supervisor();
		try {
			s = sdi.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static BenefitsCoordinator loginBC(String username, String password) {
		BenefitsCoordinator bc = new BenefitsCoordinator();
		try {
			bc = bcdi.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bc;
	}
	
	public static Supervisor getSupervisor(Supervisor s) {
		try {
			s = sdi.getSupervisorByUser(s.getUser());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public static BenefitsCoordinator getBC(BenefitsCoordinator bc) {
		try {
			bc = bcdi.getBcByUser(bc.getUser());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bc;
	}
	
	
	
	
	
	
	public static void setSupervisorCredentials(Supervisor s, HttpSession session) {
		session.setAttribute("usertype", "Manager");
		session.setAttribute("username", s.getUser());
		session.setAttribute("id", s.getSup_id());
		session.setAttribute("lName", s.getlName());
		session.setAttribute("fName", s.getfName());
		session.setAttribute("Dept", s.getDeptName());
	}
	
	public static void setBCCredentials(BenefitsCoordinator bc, HttpSession session) {
		session.setAttribute("usertype", "chairman");
		session.setAttribute("username", bc.getUser());
		session.setAttribute("id", bc.getBc_id());
		session.setAttribute("lName", bc.getlName());
		session.setAttribute("fName", bc.getfName());
	}
	
	public static void setEmployeeCredentials(Employee e, HttpSession session) {
		session.setAttribute("usertype", "employee");
		session.setAttribute("username", e.getUser());
		session.setAttribute("Reimbursements", e.getTotalReimbursements());
		session.setAttribute("id", e.getEmp_id());
		session.setAttribute("lName", e.getlName());
		session.setAttribute("fName", e.getfName());
		session.setAttribute("Dept", e.getDeptName());	
	}
	
}
