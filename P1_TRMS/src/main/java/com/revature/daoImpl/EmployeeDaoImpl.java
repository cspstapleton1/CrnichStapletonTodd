package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	ConnFactory cf = ConnFactory.getInstance();

	public Employee getEmployeeById(int id) throws SQLException {
		//Declare connection variables
		Connection conn = cf.getConnection();
		Employee e = new Employee();
		String sql = "select from trms.employee where emp_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);

		//Query for employee by id and return
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getDouble(7));
		}
		return e;
	}//End of method getEmployeeById
	

	public void insertEmployee(Employee e) throws SQLException {
		//Declare connection variables
		Connection conn = cf.getConnection();
		String sql = "insert into trms.employee values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		//Insert data from employee into database
		ps.setInt(1, e.getEmp_id());
		ps.setString(2, e.getfName());
		ps.setString(3, e.getlName());
		ps.setString(4, e.getDeptName());
		ps.setString(5, e.getUser());
		ps.setString(6, e.getPw());
		ps.setDouble(7, e.getTotalReimbursements());
		ps.execute();

		//Commit changes to database
		ps = conn.prepareStatement("commit");
		ps.execute();

	}//End of method InsertEmployee

	public Employee login(String user, String pw) throws SQLException {
		//Declare connection variables
		Connection conn = cf.getConnection();
		String sql = "select emp_id, fname, lname, deptname, username, reimbursement"
					+" from trms.employee where username = ? and pw = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//Return Employee with login credentials. If login credentials 
		//don't match anyone in the database, returns null
		ps.setString(1, user);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		Employee e = new Employee();
		while(rs.next()) {
			e.setEmp_id(rs.getInt(1));
			e.setfName(rs.getString(2));
			e.setlName(rs.getString(3));
			e.setDeptName(rs.getString(4));
			e.setUser(rs.getString(5));
			e.setTotalReimbursements(rs.getDouble(6));
		}
		return e;
	}

}//End of Class EmployeeDaoImpl
