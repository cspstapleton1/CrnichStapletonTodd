package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Employee;

public interface EmployeeDao {
	public Employee getEmployeeById(int id) throws SQLException;
	public void InsertEmployee(Employee e) throws SQLException;
}
