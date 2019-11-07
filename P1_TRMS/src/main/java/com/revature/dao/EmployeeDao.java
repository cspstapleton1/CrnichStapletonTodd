package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Employee;

public interface EmployeeDao {
	public Employee getEmployeeById(int id) throws SQLException;
	public void insertEmployee(Employee e) throws SQLException;
	public Employee login(String user, String pw) throws SQLException; 
}
