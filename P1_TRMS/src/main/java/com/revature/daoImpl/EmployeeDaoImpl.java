package com.revature.daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao{
	ConnFactory cf = ConnFactory.getInstance();
	
	public Employee getEmployeeById(int id) throws SQLException {
		Connection conn = cf.getConnection();
		Employee e = null;
		String sql = "";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		
		return e;
	}

	public void InsertEmployee(Employee e) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
